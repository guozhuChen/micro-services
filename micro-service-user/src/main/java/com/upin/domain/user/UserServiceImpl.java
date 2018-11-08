package com.upin.domain.user;

import com.upin.common.BasePageRequest;
import com.upin.common.GeneralPageDTO;
import com.upin.common.PageDataDTOHelper;
import com.upin.consumers.MessageConsumer;
import com.upin.dtos.LoginDTO;
import com.upin.dtos.LoginResponseDTO;
import com.upin.dtos.UserDTO;
import com.upin.exception.BaseException;
import com.upin.redis.SesssionManager;
import com.upin.util.Md5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by Leslie on 2018/7/25.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDTOHelper userDTOHelper;
    private final SesssionManager sesssionManager;
    private final MessageConsumer messageConsumer;

    @Value("${session.timeout-hours}")
    private Long timeoutHours;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDTOHelper userDTOHelper, SesssionManager sesssionManager,
                           MessageConsumer messageConsumer) {
        this.userRepository = userRepository;
        this.userDTOHelper = userDTOHelper;
        this.sesssionManager = sesssionManager;
        this.messageConsumer = messageConsumer;
    }

    @Override
    public LoginResponseDTO loginUser(@NotNull LoginDTO data) throws Exception {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        LoginAgent loginAgent = new LoginAgent(messageConsumer, sesssionManager, timeoutHours);
        if (LoginType.PASSWORD.equals(data.getLoginType())) {
            //MD5 加密(加盐)
            String password = Md5Utils.getSaltMD5(data.getPassword(), data.getLoginName());
            List<UserDTO> userDTOList = searchUser(null, null, data.getLoginName(), password, null,
                    null, null, null, null, null).getData();
            loginResponseDTO = loginAgent.loginByPassword(data, userDTOList);
        } else if (LoginType.CODE.equals(data.getLoginType())) {
            List<UserDTO> userDTOList = searchUser(null, null, data.getLoginName(), null, null,
                    null, null, null, null, null).getData();
            loginResponseDTO = loginAgent.loginByCode(data, userDTOList);
        }
        return loginResponseDTO;
    }

    @Override
    public UserDTO save(UserDTO data) throws Exception {
        if (StringUtils.isBlank(data.getLoginName())) {
            throw new BaseException("登录账号不能为空");
        }
        User user = userRepository.findByLoginName(data.getLoginName());
        if (user != null) {
            throw new BaseException("登录账号已存在");
        }
        return userDTOHelper.toDTO(userRepository.saveAndFlush(userDTOHelper.toModel(data)));
    }

    @Override
    public GeneralPageDTO<UserDTO> searchUser(Integer offset, Integer limit, String loginName, String password, String userTypeId,
                                              Integer rank, String status, String cardId, String gender, String search) {
        Sort sort = new Sort(Sort.Direction.ASC, "createdDate");
        Pageable pageable = new BasePageRequest(offset, limit, sort);
        Specification<User> specification = getSpecification(loginName, password, userTypeId, rank, status, cardId, gender, search);
        Page<User> userPage = userRepository.findAll(specification, pageable);
        List<UserDTO> userDTOList = userDTOHelper.toDTOList(userPage.getContent());
        GeneralPageDTO<UserDTO> data = new GeneralPageDTO<>();
        data.setData(userDTOList);
        PageDataDTOHelper.fillPage(data, userPage.getTotalElements(), userPage.getTotalPages(), offset, limit);
        return data;
    }

    private Specification<User> getSpecification(String loginName, String password, String userTypeId, Integer rank, String status,
                                                 String cardId, String gender, String search) {
        Specification<User> specification = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNoneBlank(loginName)) {
                predicates.add(criteriaBuilder.equal(root.get("loginName"), loginName));
            }
            if (StringUtils.isNoneBlank(password)) {
                predicates.add(criteriaBuilder.equal(root.get("password"), password));
            }
            if (StringUtils.isNoneBlank(userTypeId)) {
                predicates.add(criteriaBuilder.equal(root.get("userTypeId"), userTypeId));
            }
            if (rank != null) {
                predicates.add(criteriaBuilder.equal(root.get("rank"), rank));
            }
            if (StringUtils.isNoneBlank(status)) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }
            if (StringUtils.isNoneBlank(cardId)){
                predicates.add(criteriaBuilder.equal(root.get("userDetail").get("cardId"), cardId));
            }
            if (StringUtils.isNoneBlank(gender)){
                predicates.add(criteriaBuilder.equal(root.get("userDetail").get("gender"), gender));
            }
            if (StringUtils.isNoneBlank(search)){
                predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("loginName"), "%" + search + "%"),
                        criteriaBuilder.like(root.get("userDetail").get("name"), "%" + search + "%"),
                        criteriaBuilder.like(root.get("userDetail").get("cardId"), "%" + search + "%"),
                        criteriaBuilder.like(root.get("userDetail").get("phone"), "%" + search + "%")));
            }
            return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        return specification;
    }

}
