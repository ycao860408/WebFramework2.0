package com.atguigu.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
@RequestMapping("/files")
public class FileController {
    @PostMapping("/uploading")
    public String fileUpload(@RequestParam("username") String username, @RequestParam("photo")MultipartFile photo) {
        System.out.println("username: " + username);
        String tempName = photo.getOriginalFilename();
        int idx = tempName.lastIndexOf(".");
        String ext = tempName.substring(idx + 1);
        String newName = UUID.randomUUID().toString().replaceAll("-", "") + "." + ext;
        try {
            File file = new File("D:/doufu/develops/JavaWeb0622/SpringMVC/SpringMVC06-FileAndInterceptor/src/main/webapp/photo/" + newName);
            photo.transferTo(file);
            System.out.println(file.getAbsolutePath());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }

    @GetMapping("/downloading")
    public ResponseEntity<byte[]> fildDownload(@RequestParam("fileName") String fileName, HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/photo/" + fileName);

        try {
            String mimeType = servletContext.getMimeType("/photo/" + fileName);
            MultiValueMap<String, String> headers = new HttpHeaders();
            headers.add("Content-Type", mimeType);
            headers.add("Content-Disposition", "attachement; filename=" + fileName);

            byte[] bytes = IOUtils.toByteArray(inputStream);
            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
    }
}
