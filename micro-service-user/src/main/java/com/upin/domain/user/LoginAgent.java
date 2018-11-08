package com.upin.domain.user;

import com.upin.consumers.MessageConsumer;
import com.upin.dtos.*;
import com.upin.exception.BaseException;
import com.upin.redis.SesssionManager;
import com.upin.session.SessionDTO;
import com.upin.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by Leslie on 2018/7/27.
 */
public class LoginAgent {
    private MessageConsumer messageConsumer;
    private SesssionManager sesssionManager;
    private Long timeoutHours;

    @Autowired
    public LoginAgent(MessageConsumer messageConsumer, SesssionManager sesssionManager, Long timeoutHours) {
        this.messageConsumer = messageConsumer;
        this.sesssionManager = sesssionManager;
        this.timeoutHours = timeoutHours;
    }

    /**
     * 动态登陆码登录
     */
    public LoginResponseDTO loginByCode(LoginDTO loginDTO, List<UserDTO> userDTOList) throws BaseException {
        if (CollectionUtils.isEmpty(userDTOList)) {
            throw new BaseException("当前账号不存在");
        }
        if (UserStatus.FREEZE.equals(userDTOList.get(0).getStatus())) {
            throw new BaseException("当前账号已冻结");
        }
        if (UserStatus.ABANDON.equals(userDTOList.get(0).getStatus())) {
            throw new BaseException("当前账号已注销");
        }
        LoginResponseDTO data = new LoginResponseDTO();

        Object object = messageConsumer.validation(loginDTO.getLoginName(), loginDTO.getPassword()).getBody();

        if (object instanceof Boolean) {
            boolean isTrue = (boolean) object;
            if (isTrue) {
                return data.token(buildSession(userDTOList)).user(userDTOList.get(0));
            } else {
                throw new BaseException("动态密码不正确");
            }
        }
        if (object instanceof CommonResponseDTO) {
            CommonResponseDTO commonResponseDTO = (CommonResponseDTO) object;
            throw new BaseException(commonResponseDTO.getMessage());
        }
        return null;
    }

    /***
     *  账号密码登录
     */
    public LoginResponseDTO loginByPassword(LoginDTO loginDTO, List<UserDTO> userDTOList) throws BaseException {
        if (CollectionUtils.isEmpty(userDTOList)) {
            throw new BaseException("账号或密码不正确");
        }
        if (UserStatus.FREEZE.equals(userDTOList.get(0).getStatus())) {
            throw new BaseException("当前账号已冻结");
        }
        if (UserStatus.ABANDON.equals(userDTOList.get(0).getStatus())) {
            throw new BaseException("当前账号已注销");
        }
        return new LoginResponseDTO().token(buildSession(userDTOList)).user(userDTOList.get(0));
    }

    /**
     * 构建session
     */
    private String buildSession(List<UserDTO> userDTOList) {
        SessionDTO session = new SessionDTO();
        List<RoleDTO> roleDTOList = userDTOList.get(0).getRoles();
        List<String> roleStringList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(roleDTOList)) {
            for (RoleDTO roleDTO : roleDTOList) {
                roleStringList.add(roleDTO.getRoleName());
            }
        }
        String token = UUIDUtils.getUUID();
        session.token(token).userId(userDTOList.get(0).getId()).roles(roleStringList);
        sesssionManager.buildSession(token, session, timeoutHours);
        return token;
    }
}
