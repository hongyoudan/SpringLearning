package com.hyd.springboot_mybatis.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.hyd.springboot_mybatis.domain.User;
import com.hyd.springboot_mybatis.mapper.UserMapper;
import com.hyd.springboot_mybatis.service.IUserService;
import com.hyd.springboot_mybatis.utils.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: hayden
 * @Date: 2023-01-07
 * @Description: IUserServiceImpl
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 获取用户列表
     *
     * @param user
     * @return
     */
    @Override
    public List<User> selectUserList(User user) {
        return userMapper.selectUserList(user);
    }

    /**
     * 根据 ID 查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * 根据 NickName 校验用户是否存在
     *
     * @param user
     * @return
     */
    @Override
    public String checkUserByNickName(User user) {

        User userInfo = userMapper.selectUserByNickName(user.getNickName());

        // 如果根据 Nickname 查询用户信息不为空，即表示昵称已存在
        if (ObjectUtil.isNotNull(userInfo)) {

            return Constants.EXIST;
        }
        return Constants.NOT_EXIST;
    }

    /**
     * 根据 phoneNumber 校验用户是否存在
     *
     * @param user
     * @return
     */
    @Override
    public String checkUserByPhoneNum(User user) {

        User userInfo = userMapper.selectUserByPhoneNum(user.getPhoneNumber());

        if (ObjectUtil.isNotNull(userInfo)) {
            return Constants.EXIST;
        }
        return Constants.NOT_EXIST;
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /**
     * 根据 ID 删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public int deleteUserById(Integer userId) {

        return userMapper.deleteUserById(userId);
    }

    /**
     * 根据 ID 更新用户信息
     *
     * @return
     */
    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    /**
     * 校验用户是否存在
     *
     * @param user
     * @return
     */
    @Override
    public String checkUserIsExist(User user) {

        User userList = userMapper.selectUserById(user.getUserId());
        if (ObjectUtil.isNotNull(userList)) {
            return Constants.EXIST;
        }

        return Constants.NOT_EXIST;
    }
}
