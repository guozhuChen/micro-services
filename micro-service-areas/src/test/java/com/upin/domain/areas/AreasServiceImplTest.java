package com.upin.domain.areas;

import com.upin.MicroServiceAreasApplication;
import com.upin.dtos.AreasDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Created by Leslie on 2018/10/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MicroServiceAreasApplication.class, value = "spring.jpa.hibernate.ddl-auto = none")
public class AreasServiceImplTest {
    @Autowired
    private AreasService areasService;

    @Test
    public void getParentById(){
        Integer areaId = 110101;
        AreasDTO areas = areasService.getParentById(areaId);
        System.out.println(areas);
    }

    @Test
    public void getChildrenById(){
        Integer areaId = 110000;
        AreasDTO areas = areasService.getChildrenById(areaId);
        System.out.println(areas);
    }

    @Test
    public void getAll(){
        String type = "province";
        List<AreasDTO> areasDTOList = areasService.getChildrenByType(type);
        System.out.println(areasDTOList);
    }
}