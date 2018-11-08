package com.upin.domain.areas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Created by Leslie on 2018/10/31.
 */
public interface AreasRepository extends JpaRepository<Areas, String>, JpaSpecificationExecutor<Areas> {

    Areas findById(Integer areaId);

    List<Areas> findByType(String type);
}
