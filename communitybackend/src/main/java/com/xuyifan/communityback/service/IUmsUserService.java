package com.xuyifan.communityback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuyifan.communityback.model.dto.LoginData;
import com.xuyifan.communityback.model.dto.RegisterData;
import com.xuyifan.communityback.model.entity.BmsBillboard;
import com.xuyifan.communityback.model.entity.UmsUser;


public interface IUmsUserService extends IService<UmsUser> {

    UmsUser infoRegister(RegisterData registerData);
    String infoLogin(LoginData loginData);
    UmsUser getUserByName(String userName);

}
