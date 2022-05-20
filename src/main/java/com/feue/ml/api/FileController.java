package com.feue.ml.api;

import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Feue
 * @create 2022-04-28 10:01
 */
@RestController
@RequestMapping("file")
public class FileController {
    @Value("${upload.file.path}")
    private String uploadPathStr;

    @RequestMapping("upload")
    public UnifyResponse<Boolean> upload(@RequestParam MultipartFile file,
                                         @RequestParam String filename) {
        if (file == null || file.isEmpty() || filename == null || filename.isEmpty()) {
            return new UnifyResponse<>(false, "文件无效");
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path uploadPath = Paths.get(uploadPathStr);
            if (!uploadPath.toFile().exists()) {
                uploadPath.toFile().mkdirs();
            }
            Files.copy(inputStream, uploadPath.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("upload file: filename is "+filename);
            return new UnifyResponse<>(true, "上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return new UnifyResponse<>(false, "上传失败");
        }
    }

    @RequestMapping("download")
    public ResponseEntity<FileSystemResource> download(@RequestParam String filename) {
        if (filename == null || filename.isEmpty()) {
            return null;
        }
        File file = Paths.get(uploadPathStr).resolve(filename).toFile();
        if (file.exists() && file.canRead()) {
            System.out.println("download file: filename is "+filename);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new FileSystemResource(file));
        } else {
            return null;
        }
    }
}
