package io.swagger.api;

import io.swagger.model.MessageRequestDTO;
import io.swagger.model.CommonResponseDTO;

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



@Api(value = "message", description = "the message API")
public interface MessageApi {

    @ApiOperation(value = "send message", notes = "", response = CommonResponseDTO.class, tags={ "message", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "success", response = CommonResponseDTO.class) })
    @RequestMapping(value = "/message/sendTemplateCode",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<CommonResponseDTO> messageSendTemplateCodePost(

@ApiParam(value = "" ,required=true ) @RequestBody MessageRequestDTO data

);

}
