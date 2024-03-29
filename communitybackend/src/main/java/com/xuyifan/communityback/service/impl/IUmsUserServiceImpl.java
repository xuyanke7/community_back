package com.xuyifan.communityback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xuyifan.communityback.common.exception.ApiAsserts;
import com.xuyifan.communityback.jwt.JwtUtil;
import com.xuyifan.communityback.mapper.UmsUserMapper;
import com.xuyifan.communityback.model.dto.LoginData;
import com.xuyifan.communityback.model.dto.RegisterData;
import com.xuyifan.communityback.model.entity.UmsUser;
import com.xuyifan.communityback.service.IUmsUserService;
import com.xuyifan.communityback.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import java.util.Date;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class IUmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser>
        implements IUmsUserService {


    @Override
    public UmsUser infoRegister(RegisterData registerData) {
        //查询是否有相同的用户
        LambdaQueryWrapper<UmsUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsUser::getUsername,registerData.getName()).or().eq(UmsUser::getEmail,registerData.getEmail());
        UmsUser seletedUser = this.baseMapper.selectOne(wrapper);

        if (!ObjectUtils.isEmpty(seletedUser)) {
            ApiAsserts.fail("账号或邮箱已存在！");
        }
        System.out.println(registerData.getName() + registerData.getPass());

        UmsUser addedUser = UmsUser.builder()
                .username(registerData.getName())
                .alias(registerData.getName())
                .password(MD5Utils.getPwd(registerData.getPass()))
                .email(registerData.getEmail())
                .createTime(new Date())
                .status(true)
                .build();
        baseMapper.insert(addedUser);

        return addedUser;
    }

    @Override
    public String infoLogin(LoginData loginData) {


        String token = null;
        try {
            UmsUser user = getUserByName(loginData.getUsername());
            String encodePwd = MD5Utils.getPwd(loginData.getPassword());
            log.info("输入密码："+ encodePwd+"正确密码："+ user.getPassword());
            if(!encodePwd.equals(user.getPassword()))
            {
                throw new Exception("密码错误");
            }
            token = JwtUtil.generateToken(user.getUsername());
            log.warn(token);
        } catch (Exception e) {
            log.warn("用户不存在or密码验证失败=======>{}", loginData.getUsername());
        }
        log.warn(token);
        return token;
    }

    @Override
    public UmsUser getUserByName(String userName) {
        LambdaQueryWrapper<UmsUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsUser::getUsername,userName);
        return this.baseMapper.selectOne(wrapper);
    }
}
