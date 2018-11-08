package com.upin.domain.role;

import com.upin.dtos.RoleDTO;
import com.upin.util.TimeUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created by Leslie on 2018/7/27.
 */
@Component
public class RoleDTOHelper {

    public RoleDTO toSimpleDTO(Role role) {
        if (role == null) {
            return null;
        }
        return new RoleDTO().id(role.getId()).createdDate(TimeUtils.dateToString(role.getCreatedDate()))
                .lastModifiedDate(TimeUtils.dateToString(role.getLastModifiedDate())).roleName(role.getRoleName())
                .description(role.getDescription()).status(role.getStatus());

    }

    public List<RoleDTO> toSimpleDTOList(List<Role> roleList) {
        if (CollectionUtils.isEmpty(roleList)){
            return null;
        }
        return roleList.stream().map(this::toSimpleDTO).collect(Collectors.toList());
    }


    /**
     * DTO 只转换 parent
     */
    public RoleDTO toParentDTO(Role role){
        if (role == null){
            return null;
        }
        return new RoleDTO().id(role.getId()).createdDate(TimeUtils.dateToString(role.getCreatedDate()))
                .lastModifiedDate(TimeUtils.dateToString(role.getLastModifiedDate())).roleName(role.getRoleName())
                .parent(toParentDTO(role.getParent()))
                .childrens(CollectionUtils.isEmpty(role.getChildrens()) ? null : toSimpleDTOList(new ArrayList<>(role.getChildrens())))
                .description(role.getDescription()).status(role.getStatus());

    }

    public List<RoleDTO> toParentDTOList(List<Role> roleList) {
        if (CollectionUtils.isEmpty(roleList)){
            return null;
        }
        return roleList.stream().map(this::toParentDTO).collect(Collectors.toList());
    }

    /**
     * DTO 只转换 children
     */
    public RoleDTO toChildrenDTO(Role role){
        if (role == null){
            return null;
        }
        return new RoleDTO().id(role.getId()).createdDate(TimeUtils.dateToString(role.getCreatedDate()))
                .lastModifiedDate(TimeUtils.dateToString(role.getLastModifiedDate())).roleName(role.getRoleName())
                .parent(toSimpleDTO(role.getParent()))
                .childrens(CollectionUtils.isEmpty(role.getChildrens()) ? null : toChildrenDTOList(new ArrayList<>(role.getChildrens())))
                .description(role.getDescription()).status(role.getStatus());
    }

    public List<RoleDTO> toChildrenDTOList(List<Role> roleList) {
        if (CollectionUtils.isEmpty(roleList)){
            return null;
        }
        return roleList.stream().map(this::toChildrenDTO).collect(Collectors.toList());
    }

    public Role toSimpleModel(RoleDTO roleDTO) {
        if (roleDTO == null) {
            return null;
        }
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setCreatedDate(TimeUtils.stringToDate(roleDTO.getCreatedDate()));
        role.setLastModifiedDate(TimeUtils.stringToDate(roleDTO.getLastModifiedDate()));
        role.setRoleName(roleDTO.getRoleName());
        role.setDescription(roleDTO.getDescription());
        role.setStatus(roleDTO.getStatus());
        return role;

    }

    public List<Role> toSimpleModelList(List<RoleDTO> roleDTOList) {
        if (CollectionUtils.isEmpty(roleDTOList)){
            return null;
        }
        return roleDTOList.stream().map(this::toSimpleModel).collect(Collectors.toList());
    }

    public Role toModel(RoleDTO roleDTO) {
        if (roleDTO == null) {
            return null;
        }
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setCreatedDate(TimeUtils.stringToDate(roleDTO.getCreatedDate()));
        role.setLastModifiedDate(TimeUtils.stringToDate(roleDTO.getLastModifiedDate()));
        role.setRoleName(roleDTO.getRoleName());
        role.setParent(toSimpleModel(roleDTO.getParent()));
        role.setChildrens(CollectionUtils.isEmpty(roleDTO.getChildrens()) ? null : new HashSet<>(toSimpleModelList(roleDTO.getChildrens())));
        role.setDescription(roleDTO.getDescription());
        role.setStatus(roleDTO.getStatus());
        return role;
    }

    public List<Role> toModelList(List<RoleDTO> roleDTOList) {
        if (CollectionUtils.isEmpty(roleDTOList)) {
            return null;
        }
        return roleDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }
}
