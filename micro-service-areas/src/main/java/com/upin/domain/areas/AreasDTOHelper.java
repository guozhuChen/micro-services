package com.upin.domain.areas;

import com.upin.dtos.AreasDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created by Leslie on 2018/10/31.
 */
@Component
public class AreasDTOHelper {

    /**
     * DTO 转换 simple
     */
    public AreasDTO toSimpleDTO(Areas areas) {
        if (areas == null){
            return null;
        }
        return new AreasDTO().id(areas.getId()).areaName(areas.getAreaName()).pinYin(areas.getPinYin())
                .shortName(areas.getShortName()).type(areas.getType()).flag(areas.isFlag())
                .lat(areas.getLat()).lng(areas.getLng());
    }

    public List<AreasDTO> toSimpleDTOList(List<Areas> areasList) {
        if (CollectionUtils.isEmpty(areasList)){
            return null;
        }
        return areasList.stream().map(this::toSimpleDTO).collect(Collectors.toList());
    }

    /**
     * DTO 只转换 parent
     */
    public AreasDTO toParentDTO(Areas areas){
        if (areas == null){
            return null;
        }
        return new AreasDTO().id(areas.getId()).areaName(areas.getAreaName()).pinYin(areas.getPinYin())
                .shortName(areas.getShortName())
                .parent(toParentDTO(areas.getParent()))
                .childrens(toSimpleDTOList(new ArrayList<>(areas.getChildrens())))
                .type(areas.getType()).flag(areas.isFlag())
                .lat(areas.getLat()).lng(areas.getLng());
    }

    public List<AreasDTO> toParentDTOList(List<Areas> areasList) {
        if (CollectionUtils.isEmpty(areasList)){
            return null;
        }
        return areasList.stream().map(this::toParentDTO).collect(Collectors.toList());
    }

    /**
     * DTO 只转换 children
     */
    public AreasDTO toChildrenDTO(Areas areas){
        if (areas == null){
            return null;
        }
        return new AreasDTO().id(areas.getId()).areaName(areas.getAreaName()).pinYin(areas.getPinYin())
                .shortName(areas.getShortName()).parent(toSimpleDTO(areas.getParent()))
                .childrens(toChildrenDTOList(new ArrayList<>(areas.getChildrens())))
                .type(areas.getType()).flag(areas.isFlag())
                .lat(areas.getLat()).lng(areas.getLng());
    }

    public List<AreasDTO> toChildrenDTOList(List<Areas> areasList) {
        if (CollectionUtils.isEmpty(areasList)){
            return null;
        }
        return areasList.stream().map(this::toChildrenDTO).collect(Collectors.toList());
    }
}
