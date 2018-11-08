package com.upin.apis;

import com.upin.dtos.LoginDTO;
import com.upin.dtos.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * @Created by Leslie on 2018/7/25.
 */
@RequestMapping("/user")
public interface UserApi {
    /**
     * 登录 login
     *
     * @param data String  loginName  登录账号
     *             String password   密码 (设计为MD5 加盐加密)
     *             Integer loginType  1 : 账号密码登录    2 : 手机动态码登录
     */
    @RequestMapping(value = "/login", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    ResponseEntity<Object> loginUser(@NotNull @RequestBody LoginDTO data) throws Exception;

    /**
     * user 新增 POST (符合RESTful 风格)
     */
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    ResponseEntity<Object> save(@NotNull @RequestBody UserDTO data) throws Exception;

    /**
     * 查询user
     *
     * @param loginName  登录账号
     * @param password   密码
     * @param userTypeId 用户类型
     * @param rank       等级
     * @param status     状态
     * @param cardId     身份证ID
     * @param gender     性别
     * @param search     模糊查询 (登录账号或真实姓名或身份证ID或手机号)
     */
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.GET)
    ResponseEntity<Object> searchUser(@RequestParam(value = "offset", required = false) Integer offset,
                                      @RequestParam(value = "limit", required = false) Integer limit,
                                      @RequestParam(value = "loginName", required = false) String loginName,
                                      @RequestParam(value = "password", required = false) String password,
                                      @RequestParam(value = "userTypeId", required = false) String userTypeId,
                                      @RequestParam(value = "rank", required = false) Integer rank,
                                      @RequestParam(value = "status", required = false) String status,
                                      @RequestParam(value = "cardId", required = false) String cardId,
                                      @RequestParam(value = "gender", required = false) String gender,
                                      @RequestParam(value = "search", required = false) String search) throws Exception;

}
