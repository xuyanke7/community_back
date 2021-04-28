package com.xuyifan.communityback.controller;


import com.xuyifan.communityback.common.api.ApiResult;
import com.xuyifan.communityback.model.dto.LoginData;
import com.xuyifan.communityback.model.dto.RegisterData;
import com.xuyifan.communityback.model.entity.BmsTip;
import com.xuyifan.communityback.model.entity.UmsUser;
import com.xuyifan.communityback.service.IBmsTipService;
import com.xuyifan.communityback.service.IUmsUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ums/user")
public class UmsUserController extends BaseController{

    @Resource
    private IUmsUserService umsUserService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResult<Map<String,UmsUser>> register(@Valid @RequestBody RegisterData registerData){
        UmsUser addedUser = umsUserService.infoRegister(registerData);

        //这里返回类或者map都没关系，因为前端没有用到返回的对象
        Map<String,UmsUser> userMap = new HashMap<String,UmsUser>(16);
        userMap.put("user",addedUser);
        return  ApiResult.success(userMap);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult<Map<String,String>> login(@Valid @RequestBody LoginData loginData){
        String token = umsUserService.infoLogin(loginData);

        Map<String,String> tokenMap = new HashMap<String,String>(16);
        tokenMap.put("token",token);
        if(token==null){
            return ApiResult.failed("用户名或密码错误");
        }
        else{
            return  ApiResult.success(tokenMap,"登录成功");
        }
    }

}
