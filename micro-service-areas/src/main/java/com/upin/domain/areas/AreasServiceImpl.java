package com.upin.domain.areas;

import com.upin.dtos.AreasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by Leslie on 2018/10/31.
 */
@Service
public class AreasServiceImpl implements AreasService {
    private final AreasRepository repository;
    private final AreasDTOHelper helper;

    @Autowired
    public AreasServiceImpl(AreasRepository repository, AreasDTOHelper helper) {
        this.repository = repository;
        this.helper = helper;
    }


    @Override
    public AreasDTO getParentById(Integer areaId) {
        return helper.toParentDTO(repository.findById(areaId));
    }

    @Override
    public AreasDTO getChildrenById(Integer areaId) {
        return helper.toChildrenDTO(repository.findById(areaId));
    }

    @Override
    public List<AreasDTO> getChildrenByType(String type) {
        return helper.toChildrenDTOList(repository.findByType(type));
    }
}
