package com.hyd.springboot_mybatis.service;

import com.hyd.springboot_mybatis.domain.User;

import java.util.List;

/**
 * @Author: hayden
 * @Date: 2023-01-07
 * @Description: IUserService
 */
public interface IUserService {

    /**
     * 查询用户列表
     *
     * @param user
     * @return
     */
    List<User> selectUserList(User user);

    /**
     * 根据 ID 查询用户信息
     *
     * @param userId
     * @return
     */
    User selectUserById(Integer userId);

    /**
     * 根据 NickName 校验用户是否存在
     * @param user
     * @return
     */
    String checkUserByNickName(User user);

    /**
     * 根据 phoneNumber 校验用户是否存在
     * @param user
     * @return
     */
    String checkUserByPhoneNum(User user);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据 ID 删除用户
     *
     * @return
     */
    int deleteUserById(Integer userId);

    /**
     * 根据 ID 更新用户信息
     *
     * @return
     */
    int updateUserById(User user);

    /**
     * 校验用户是否存在
     * @param user
     * @return
     */
    String checkUserIsExist(User user);
}
