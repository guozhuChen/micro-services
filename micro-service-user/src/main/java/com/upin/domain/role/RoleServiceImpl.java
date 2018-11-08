package com.upin.domain.role;

import com.upin.dtos.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by Leslie on 2018/11/2.
 */
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final RoleDTOHelper helper;

    @Autowired
    public RoleServiceImpl(RoleRepository repository, RoleDTOHelper helper) {
        this.repository = repository;
        this.helper = helper;
    }

    @Override
    public RoleDTO save(RoleDTO data) throws Exception {
        return helper.toChildrenDTO(repository.save(helper.toModel(data)));
    }
}
