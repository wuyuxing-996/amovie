package com.wyx.amovie.controller.admin;

import com.wyx.amovie.utils.Myproperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wyx
 * @date 2019-08-28 09:34
 */
@RestController
@CrossOrigin(value = "*", allowCredentials = "true")
@RequestMapping("/api/upload")
public class AdminUploadController {

    @Autowired
    private Myproperties myproperties;

    @PostMapping
    public ResponseEntity upload(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException {

        String filepath = myproperties.getFilepath();
        File file1 = new File(filepath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        String filename = multipartFile.getOriginalFilename();

        String localPath = filepath + File.separator + filename;

        File file2 = new File(localPath);

        multipartFile.transferTo(file2);
        Map map = new HashMap();
        //   /upload/xxx.jpg
        String url = File.separator + "upload" + File.separator + filename;
        map.put("url", url);
        return new ResponseEntity(map, HttpStatus.OK);
    }
}
