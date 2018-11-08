package com.upin.domain.user;

import com.upin.common.GeneralPageDTO;
import com.upin.dtos.CommonResponseDTO;
import com.upin.dtos.LoginDTO;
import com.upin.dtos.LoginResponseDTO;
import com.upin.dtos.UserDTO;

import javax.validation.constraints.NotNull;

/**
 * @Created by Leslie on 2018/7/25.
 */
public interface UserService {

    LoginResponseDTO loginUser(@NotNull LoginDTO data) throws Exception;

    UserDTO save(UserDTO data) throws Exception;

    GeneralPageDTO<UserDTO> searchUser(Integer offset, Integer limit, String loginName, String password, String userTypeId,
                                       Integer rank, String status, String cardId, String gender, String search);
}
