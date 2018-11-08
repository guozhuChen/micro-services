package io.swagger.api;

import io.swagger.model.CommonResponseDTO;
import java.io.File;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;




@Controller
public class OssApiController implements OssApi {

    public ResponseEntity<CommonResponseDTO> ossTimestampUrlGet(@ApiParam(value = "", required = true) @RequestParam(value = "url", required = true) String url



) {
        // do some magic!
        return new ResponseEntity<CommonResponseDTO>(HttpStatus.OK);
    }

    public ResponseEntity<CommonResponseDTO> ossUploadPost(


@ApiParam(value = "file detail") @RequestPart("file") MultipartFile file
) {
        // do some magic!
        return new ResponseEntity<CommonResponseDTO>(HttpStatus.OK);
    }

}