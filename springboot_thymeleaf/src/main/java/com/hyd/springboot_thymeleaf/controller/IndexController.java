package com.hyd.springboot_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import java.util.*;

/**
 * @Author: hayden
 * @Date: 2023-01-07
 * @Description:
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String p1(Model model) {
        /**
         * 变量输出
         */
        model.addAttribute("text", "后端传过来的文本");
        model.addAttribute("value", "后端传过来的value");

        /**
         * 操作时间
         */
        model.addAttribute("date", new Date());

        /**
         * 操作时间
         */
        model.addAttribute("gender", 1);
        model.addAttribute("switch", 6);

        /**
         * 迭代遍历
         */
        // List
        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", 11, "男"));
        userList.add(new User("丽莉", 18, "女"));
        userList.add(new User("王武", 31, "男"));
        model.addAttribute("userList", userList);
        // Map
        HashMap<Integer, User> userMap = new HashMap<>();
        userMap.put(0, new User("归浩阔", 22, "男"));
        userMap.put(1, new User("暴飞雨", 23, "女"));
        model.addAttribute("userMap", userMap);

        /**
         * url拼接
         */
        model.addAttribute("year", "2023");
        model.addAttribute("month", "01");


        return "index";
    }

    @GetMapping("/jump/{year}/{month}")
    @ResponseBody
    public String jump(@PathVariable String year, @PathVariable String month) {
        return "year:" + year + "，" + "month:" + month;
    }

    static class User {

        public User(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        private String name;
        private int age;
        private String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

}
