package io.swagger.api;

import io.swagger.model.MessageRequestDTO;
import io.swagger.model.CommonResponseDTO;

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
public class MessageApiController implements MessageApi {

    public ResponseEntity<CommonResponseDTO> messageSendTemplateCodePost(

@ApiParam(value = "" ,required=true ) @RequestBody MessageRequestDTO data

) {
        // do some magic!
        return new ResponseEntity<CommonResponseDTO>(HttpStatus.OK);
    }

}
