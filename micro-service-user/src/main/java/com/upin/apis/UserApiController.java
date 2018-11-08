package com.upin.apis;

import com.upin.common.GeneralPageDTO;
import com.upin.domain.user.UserService;
import com.upin.dtos.LoginDTO;
import com.upin.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Created by Leslie on 2018/7/25.
 */
@RestController
public class UserApiController implements UserApi {
    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Object> loginUser(@NotNull @RequestBody LoginDTO data) throws Exception {
        return new ResponseEntity<>(userService.loginUser(data), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> save(@NotNull @RequestBody UserDTO data) throws Exception {
        return new ResponseEntity<>(userService.save(data), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> searchUser(@RequestParam(value = "offset", required = false) Integer offset,
                                             @RequestParam(value = "limit", required = false) Integer limit,
                                             @RequestParam(value = "loginName", required = false) String loginName,
                                             @RequestParam(value = "password", required = false) String password,
                                             @RequestParam(value = "userType", required = false) String userTypeId,
                                             @RequestParam(value = "rank", required = false) Integer rank,
                                             @RequestParam(value = "status", required = false) String status,
                                             @RequestParam(value = "cardId", required = false) String cardId,
                                             @RequestParam(value = "gender", required = false) String gender,
                                             @RequestParam(value = "search", required = false) String search) throws Exception {
        GeneralPageDTO<UserDTO> data = userService.searchUser(offset, limit, loginName, password, userTypeId, rank,
                status, cardId, gender, search);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
