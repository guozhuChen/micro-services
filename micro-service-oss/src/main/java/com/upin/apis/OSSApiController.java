package com.upin.apis;

import com.upin.domain.OSSService;
import com.upin.dtos.CommonResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Created by Leslie on 2018/7/24.
 */
@RestController
public class OSSApiController implements OSSApi {
    private final OSSService ossService;

    @Autowired
    public OSSApiController(OSSService ossService) {
        this.ossService = ossService;
    }

    @Override
    public ResponseEntity<Object> upload(@RequestPart(value = "file") MultipartFile multipartFile,
                                         @RequestParam(value = "isPublic") boolean isPublic) throws Exception {
        CommonResponseDTO response = ossService.upload(multipartFile, isPublic);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Object> timeStampUrl(@RequestParam(value = "url") String url) throws Exception {
        CommonResponseDTO response = ossService.timeStampUrl(url);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
