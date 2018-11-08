package com.upin.domain.user;

import com.upin.domain.role.RoleDTOHelper;
import com.upin.dtos.RoleDTO;
import com.upin.dtos.UserDTO;
import com.upin.dtos.UserDetailDTO;
import com.upin.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created by Leslie on 2018/7/26.
 */
@Component
public class UserDTOHelper {
    private final RoleDTOHelper roleDTOHelper;

    @Autowired
    public UserDTOHelper(RoleDTOHelper roleDTOHelper) {
        this.roleDTOHelper = roleDTOHelper;
    }

    public UserDTO toDTO(User user) {
        if (user == null) {
            return new UserDTO();
        }
        return new UserDTO().id(user.getId()).createdDate(TimeUtils.dateToString(user.getCreatedDate()))
                .lastModifiedDate(TimeUtils.dateToString(user.getLastModifiedDate())).loginName(user.getLoginName())
                .password(user.getPassword()).userTypeId(user.getUserTypeId()).rank(user.getRank())
                .status(user.getStatus()).lastLoginDate(TimeUtils.dateToString(user.getLastLoginDate()))
                .userDetail(new UserDetailDTO().id(user.getUserDetail().getId()).name(user.getUserDetail().getName())
                        .gender(user.getUserDetail().getGender())
                        .birthDay(TimeUtils.dateToString(user.getUserDetail().getBirthDay()))
                        .cardType(user.getUserDetail().getCardType()).cardId(user.getUserDetail().getCardId())
                        .phone(user.getUserDetail().getPhone()).email(user.getUserDetail().getEmail())
                        .areaId(user.getUserDetail().getAreaId()).address(user.getUserDetail().getAddress())
                        .heardUrl(user.getUserDetail().getHearUrl()))
                .roles(roleDTOHelper.toChildrenDTOList(user.getRoles()));
    }

    public List<UserDTO> toDTOList(List<User> userList) {
        if (CollectionUtils.isEmpty(userList)) {
            return Collections.emptyList();
        }
        return userList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public User toModel(UserDTO userDTO) {
        User user = new User();
        if (userDTO == null) {
            return user;
        }
        user.setId(userDTO.getId());
        user.setCreatedDate(TimeUtils.stringToDate(userDTO.getCreatedDate()));
        user.setLastModifiedDate(TimeUtils.stringToDate(userDTO.getLastModifiedDate()));
        user.setLoginName(userDTO.getLoginName());
        user.setPassword(userDTO.getPassword());
        user.setUserTypeId(userDTO.getUserTypeId());
        user.setRank(userDTO.getRank());
        user.setStatus(userDTO.getStatus());
        user.setLastLoginDate(TimeUtils.stringToDate(userDTO.getLastLoginDate()));
        UserDetail userDetail = new UserDetail();
        if (userDTO.getUserDetail() != null) {
            userDetail.setId(userDTO.getUserDetail().getId());
            userDetail.setName(userDTO.getUserDetail().getName());
            userDetail.setGender(userDTO.getUserDetail().getGender());
            userDetail.setBirthDay(TimeUtils.stringToDate(userDTO.getUserDetail().getBirthDay()));
            userDetail.setCardType(userDTO.getUserDetail().getCardType());
            userDetail.setCardId(userDTO.getUserDetail().getCardId());
            userDetail.setPhone(userDTO.getUserDetail().getPhone());
            userDetail.setEmail(userDTO.getUserDetail().getEmail());
            userDetail.setAreaId(userDTO.getUserDetail().getAreaId());
            userDetail.setAddress(userDTO.getUserDetail().getAddress());
            userDetail.setHearUrl(userDTO.getUserDetail().getHeardUrl());
        }
        user.setUserDetail(userDetail);
        List<RoleDTO> roleDTOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userDTO.getRoles())) {
            roleDTOList = userDTO.getRoles();
        }
        user.setRoles(roleDTOHelper.toModelList(roleDTOList));
        return user;
    }

}
