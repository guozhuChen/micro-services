package com.upin.domain.areas;

import com.upin.dtos.AreasDTO;

import java.util.List;

/**
 * @Created by Leslie on 2018/10/31.
 */
public interface AreasService {

    AreasDTO getParentById(Integer areaId);

    AreasDTO getChildrenById(Integer areaId);

    List<AreasDTO> getChildrenByType(String type);
}
