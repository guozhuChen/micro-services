package com.upin.domain;


import com.upin.MicroServiceUserApplication;
import com.upin.domain.user.UserService;
import com.upin.dtos.RoleDTO;
import com.upin.dtos.UserDTO;
import com.upin.dtos.UserDetailDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by Leslie on 2018/7/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MicroServiceUserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        value = "spring.jpa.hibernate.ddl-auto = none")
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void save() throws Exception {
        UserDTO data = new UserDTO();
        data.loginName("18727096550").password("123456").userTypeId("123").rank(1).status("available")
                .userDetail(new UserDetailDTO().name("陈国祝").cardId("123456789"));
        List<RoleDTO> roleList = new ArrayList<>();
        RoleDTO role = new RoleDTO();
        role.id("1").roleName("会员").status("available");
        roleList.add(role);
        data.roles(roleList);
        UserDTO user = userService.save(data);
        System.out.println(user.toString());
    }

    @Test
    public void searchUser() {
        String cardId = "123456789";
        List<UserDTO> userList = userService.searchUser(null, null, null, null,
                null, null, null, cardId, null, null).getData();
        System.out.println(userList);
    }

}