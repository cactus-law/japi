package com.dounine.japi.core.action.comm;

import com.dounine.japi.act.Result;
import com.dounine.japi.act.ResultImpl;
import com.dounine.japi.core.IAction;
import com.dounine.japi.entity.AddInterface;
import com.dounine.japi.entity.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 新闻工具
 * Created by huanghuanlai on 2017/1/18.
 */
@RestController
@RequestMapping("article")
public class TestAction {

    /**
     * 获取热闹新闻
     *
     * @param user 用户信息
     * @return [{name:'testName',type:'string',defaultValue:'',description:'this is des.'}]
     * @throws RuntimeException
     * @version v1
     * @deprecated yes
     */
    @org.springframework.web.bind.annotation.GetMapping(value = "v1/hots")
    @ResponseBody
    public Result hots(@Validated({User.UserADD.class, User.UserDEL.class}) User user, BindingResult bindingResult) throws RuntimeException {

        return null;
    }

    /**
     * 获取冷门新闻
     *
     * @param id 新闻编号
     * @throws RuntimeException
     * @version v1
     * @deprecated yes
     */
    @org.springframework.web.bind.annotation.GetMapping(value = "v1/list/{id}")
    @ResponseBody
    public Result testUser(@PathVariable String id) throws RuntimeException {

        return null;
    }

    /**
     * 获取冷门新闻
     *
     * @param id 新闻编号
     * @return class com.dounine.japi.entity.User
     * @throws RuntimeException
     * @version v2
     * @stable yes
     */
    @org.springframework.web.bind.annotation.PostMapping(value = "v2/list/{id}")
    @ResponseBody
    public Result testUser1(@PathVariable String id) throws RuntimeException {

        return null;
    }

    /**
     * 获取冷门新闻
     *
     * @param id 新闻编号
     * @return class com.dounine.japi.entity.User
     * @throws RuntimeException
     * @version v3
     */
    @org.springframework.web.bind.annotation.PostMapping(value = "v3/list/{id}")
    @ResponseBody
    public Result testUser3(@PathVariable String id) throws RuntimeException {

        return null;
    }


}