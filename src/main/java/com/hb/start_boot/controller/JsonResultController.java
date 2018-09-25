package com.hb.start_boot.controller;

/*
* 返回值的封装类型,带上了code状态,和msg返回说明
* */

import com.hb.start_boot.entity.JsonResult;
import com.hb.start_boot.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jsonResult")
public class JsonResultController {

    @RequestMapping("/user")
    public JsonResult<User>  getUser(){
        User user = new User(1L, "hb", "112233");
        JsonResult jsonResult = new JsonResult(user);
        return jsonResult;
    }



    @RequestMapping("/list")
    public JsonResult<User> list(){
        User user1 = new User(1L, "hb", "112233");
        User user2 = new User(2L, "fsl", "17733");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        JsonResult jsonResult = new JsonResult("10", "操作返回ok",  list);
        return jsonResult;
    }

    @RequestMapping("/map")
    public JsonResult<Map> map(){
        User user = new User(1L, "hb", "112233");
        Map map = new HashMap();
        map.put("user", user);
        map.put("type", "state");
        map.put("food", null);
        JsonResult jsonResult = new JsonResult("12", "返回成功", map);
        return jsonResult;

    }

}
