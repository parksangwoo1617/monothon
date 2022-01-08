package com.example.ddip.config;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.ddip.exception.UnexpectedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3Util {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.host}")
    private String s3Host;

    public String saveFile(MultipartFile file, String directory) {
        try {
            File uploadFile = convert(file)
                    .orElseThrow(UnexpectedException::new);
            return saveFile(uploadFile, directory);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnexpectedException();
        }
    }

    private String saveFile(File file, String directory) {
        String key = directory + "/" + UUID.randomUUID() + file.getName().substring(file.getName().lastIndexOf("."));
        amazonS3Client.putObject(new PutObjectRequest(bucket, key, file).withCannedAcl(CannedAccessControlList.PublicRead));
        file.delete();
        return s3Host + "/" + key;
    }

    private Optional<File> convert(MultipartFile file) throws IOException {
        File convertFile = new File(System.getProperty("user.dir") + "/" + file.getOriginalFilename());
        if(convertFile.createNewFile()) {
            try(FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(file.getBytes());
            }
            return Optional.of(convertFile);
        }
        return Optional.empty();
    }
}
