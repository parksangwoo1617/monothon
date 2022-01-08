package com.example.ddip.service.user;

import com.example.ddip.config.S3Util;
import com.example.ddip.dto.request.LoginRequest;
import com.example.ddip.dto.request.RegisterGoodsRequest;
import com.example.ddip.dto.request.SignUpRequest;
import com.example.ddip.dto.response.GoodsDetailInfoResponse;
import com.example.ddip.dto.response.GoodsInfoListResponse;
import com.example.ddip.dto.response.TokenResponse;
import com.example.ddip.entity.attachment.Attachment;
import com.example.ddip.entity.attachment.AttachmentRepository;
import com.example.ddip.entity.goods.Goods;
import com.example.ddip.entity.goods.GoodsRepository;
import com.example.ddip.entity.user.User;
import com.example.ddip.entity.user.UserRepository;
import com.example.ddip.exception.*;
import com.example.ddip.facade.UserFacade;
import com.example.ddip.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final GoodsRepository goodsRepository;
    private final UserFacade userFacade;
    private final AttachmentRepository attachmentRepository;
    private final S3Util s3Util;

    public ResponseEntity<TokenResponse> login(LoginRequest request) {
        UserDetails user = userRepository.findById(request.getId())
                .orElseThrow(UserNotFoundException::new);
        if (!user.getPassword().equals(request.getPassword())) {
            throw new MismatchedPasswordException();
        }

        TokenResponse token = getToken(request.getId());

        return new ResponseEntity<>(new TokenResponse(
                token.getAccessToken()
        ), HttpStatus.OK);
    }

    public void signUp(SignUpRequest request) {
        if (userRepository.findById(request.getId()).isPresent()) {
            throw new AlreadyExistIdException();
        } else {
            userRepository.save(
                    User.builder()
                            .user_id(request.getId())
                            .password(request.getPassword())
                            .nickname(request.getNickname())
                            .phoneNumber(request.getPhone_number())
                            .build()
            );
        }
    }

    public void registerGoods(RegisterGoodsRequest request) {
        Goods goods = goodsRepository.save(Goods.builder()
                .price(request.getPrice())
                .name(request.getName())
                .description(request.getDescription())
                .category(request.getCategory())
                .time(request.getTime())
                .user(userRepository.findById("chawe135")
                        .orElseThrow(UserNotFoundException::new))
                .build()
        );

        saveGoodsAttachment(goods, request.getGoods_image(), goods::setImage);
    }

    public GoodsInfoListResponse getGoodsInfoList() {
        return GoodsInfoListResponse.builder()
                .goods_list(goodsRepository.findAllByOrderByIdDesc()
                        .stream().map(goods -> GoodsInfoListResponse.of(
                                goods.getId(),
                                checkNull(goods.getImage()),
                                goods.getUser().getNickname(),
                                goods.getCategory(),
                                goods.getName(),
                                goods.getTime(),
                                goods.getPrice()
                        ))
                        .collect(Collectors.toList())
                ).build();
    }

    public List<GoodsDetailInfoResponse> getGoodsDetailInfo(Integer goods_id) {
        return goodsRepository.findById(goods_id)
                .stream().map(goods -> GoodsDetailInfoResponse.builder()
                        .goods_id(goods_id)
                        .image_url(checkNull(goods.getImage()))
                        .nickname(userRepository.findById(userFacade.getId()).get().getNickname())
                        .category(goods.getCategory())
                        .goods_name(goods.getName())
                        .time(goods.getTime())
                        .price(goods.getPrice())
                        .description(goods.getDescription())
                        .build()
                ).collect(Collectors.toList());
    }

    private String checkNull(Attachment attachment) {
        if (attachment == null) {
            return null;
        }
        return attachment.getFile_name();
    }

    private void saveGoodsAttachment(Goods goods, MultipartFile file, Consumer<Attachment> consumer) {
        Optional<String> savedFile = saveFileToStorage(file, "goods" + "/" + goods.getId());
        if (savedFile.isPresent()) {
            Attachment attachment = saveFileToDatabase(savedFile.get(), file.getOriginalFilename());
            consumer.accept(attachment);
        }
    }

    private Optional<String> saveFileToStorage(MultipartFile file, String directoryName) {
        if (file == null || file.isEmpty() || file.getOriginalFilename() == null) {
            return Optional.empty();
        }
        return Optional.of(s3Util.saveFile(file, directoryName));
    }

    private Attachment saveFileToDatabase(String fileName, String originalFileName) {
        return attachmentRepository.save(Attachment.builder()
                .file_name(fileName)
                .original_file_name(originalFileName)
                .build());
    }

    private TokenResponse getToken(String id) {
        String accessToken = jwtTokenProvider.generateAccessToken(id);
        return new TokenResponse(accessToken);
    }
}
