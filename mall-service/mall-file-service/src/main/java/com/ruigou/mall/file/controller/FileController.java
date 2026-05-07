package com.ruigou.mall.file.controller;

import com.ruigou.mall.file.minio.FileHandler;
import com.ruigou.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    private FileHandler fileHandler;

    // 上传
    @PostMapping(value = "/upload")
    public RespResult upload(MultipartFile file) throws Exception {
        fileHandler.upload(file.getOriginalFilename(),file.getBytes());
        return RespResult.ok(file.getOriginalFilename());
    }

    // 下载
    @GetMapping(value = "/download/{filename}")
    public void download(@PathVariable String filename, HttpServletResponse response) throws Exception {
        byte[] bytes = fileHandler.download(filename);
        ServletOutputStream os = response.getOutputStream();
        os.write(bytes);
    }
}