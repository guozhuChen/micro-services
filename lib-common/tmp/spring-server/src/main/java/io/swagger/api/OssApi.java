package io.swagger.api;

import io.swagger.model.CommonResponseDTO;
import java.io.File;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@Api(value = "oss", description = "the oss API")
public interface OssApi {

    @ApiOperation(value = "", notes = "", response = CommonResponseDTO.class, tags={ "oss", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success", response = CommonResponseDTO.class) })
    @RequestMapping(value = "/oss/timestampUrl",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CommonResponseDTO> ossTimestampUrlGet(@ApiParam(value = "", required = true) @RequestParam(value = "url", required = true) String url



);


    @ApiOperation(value = "upload", notes = "", response = CommonResponseDTO.class, tags={ "oss", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success", response = CommonResponseDTO.class) })
    @RequestMapping(value = "/oss/upload",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    ResponseEntity<CommonResponseDTO> ossUploadPost(


@ApiParam(value = "file detail") @RequestPart("file") MultipartFile file
);

}
