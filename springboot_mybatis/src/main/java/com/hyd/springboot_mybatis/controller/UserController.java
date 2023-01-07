package com.hyd.springboot_mybatis.controller;

import cn.hutool.core.util.StrUtil;
import com.hyd.springboot_mybatis.domain.User;
import com.hyd.springboot_mybatis.service.IUserService;
import com.hyd.springboot_mybatis.utils.Constants;
import com.hyd.springboot_mybatis.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: hayden
 * @Date: 2023-01-07
 * @Description: UserController
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 获取用户列表
     *
     * @param user
     * @return
     */
    @GetMapping("/list")
    public ResponseUtil list(User user) {
        List<User> list = userService.selectUserList(user);
        return ResponseUtil.success(list);
    }

    /**
     * 根据 ID 查询用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping(value = {"/", "/{userId}"})
    public ResponseUtil getInfo(@PathVariable Integer userId) {
        // 判空
        if (StrUtil.isEmpty(String.valueOf(userId))) {
            return ResponseUtil.error("用户ID不能为空！");
        }
        User list = userService.selectUserById(userId);
        return ResponseUtil.success(list);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @PostMapping
    public ResponseUtil insertUser(@RequestBody User user) {

        // 判空
        if (StrUtil.isEmpty(user.getNickName())) {
            return ResponseUtil.error("昵称不能为空！");
        }
        if (StrUtil.isEmpty(user.getPhoneNumber())) {
            return ResponseUtil.error("手机号码不能为空！");
        }

        // 昵称已存在
        if (Constants.EXIST.equals(userService.checkUserByNickName(user))) {
            return ResponseUtil.error("新增用户" + user.getNickName() + "失败！昵称已存在！");
        }

        // 手机号码已存在
        if (Constants.EXIST.equals(userService.checkUserByPhoneNum(user))) {
            return ResponseUtil.error("新增用户" + user.getNickName() + "失败！手机号码已存在！");
        }

        userService.insertUser(user);
        return ResponseUtil.success("新增用户 " + user.getNickName() + "成功！");
    }

    /**
     * 根据 ID 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    public ResponseUtil deleteUserById(@PathVariable Integer userId) {
        int i = userService.deleteUserById(userId);
        if (i == 0) {
            return ResponseUtil.error("删除失败！");
        }
        return ResponseUtil.success("删除用户成功！");
    }


    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping
    public ResponseUtil updateUserById(@RequestBody User user) {

        // 判空
        if (StrUtil.isEmpty(String.valueOf(user.getUserId()))) {
            return ResponseUtil.error("用户ID不能为空！");
        }
        if (StrUtil.isEmpty(user.getNickName())) {
            return ResponseUtil.error("昵称不能为空！");
        }
        if (StrUtil.isEmpty(user.getPhoneNumber())) {
            return ResponseUtil.error("手机号码不能为空！");
        }

        // 根据 userId 校验用户是否存在，不存在则返回更新失败
        if (Constants.NOT_EXIST.equals(userService.checkUserIsExist(user))) {
            return ResponseUtil.error("用户" + user.getNickName() + "不存在！更新失败！");
        }

        userService.updateUserById(user);
        return ResponseUtil.success("更新用户 " + user.getNickName() + " 成功！");
    }

}
