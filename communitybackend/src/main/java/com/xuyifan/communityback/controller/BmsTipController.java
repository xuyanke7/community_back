package com.xuyifan.communityback.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuyifan.communityback.common.api.ApiResult;
import com.xuyifan.communityback.mapper.BmsTipMapper;
import com.xuyifan.communityback.model.entity.BmsBillboard;
import com.xuyifan.communityback.model.entity.BmsTip;
import com.xuyifan.communityback.service.IBmsBillboardService;
import com.xuyifan.communityback.service.IBmsTipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tips")
public class BmsTipController extends BaseController{

    @Resource
    private IBmsTipService bmsTipService;

    @GetMapping("/show")
    public ApiResult<BmsTip> getNotices(){
        BmsTip todayTip = bmsTipService.getRandomTip();
        return ApiResult.success(todayTip);
    }

}
