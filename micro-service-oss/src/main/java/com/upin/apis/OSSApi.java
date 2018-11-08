package com.upin.apis;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Created by Leslie on 2018/7/24.
 */
@RequestMapping(value = "/oss")
public interface OSSApi {

    @RequestMapping(value = "/upload", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, method = RequestMethod.POST)
    ResponseEntity<Object> upload(@RequestPart(value = "file") MultipartFile multipartFile,
                                  @RequestParam(value = "isPublic") boolean isPublic) throws Exception;

    @RequestMapping(value = "/timeStampUrl", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.GET)
    ResponseEntity<Object> timeStampUrl(@RequestParam(value = "url") String url) throws Exception;
}
