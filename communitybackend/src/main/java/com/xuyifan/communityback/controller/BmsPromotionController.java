package com.xuyifan.communityback.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuyifan.communityback.common.api.ApiResult;
import com.xuyifan.communityback.model.entity.BmsBillboard;
import com.xuyifan.communityback.model.entity.BmsPromotion;
import com.xuyifan.communityback.service.IBmsBillboardService;
import com.xuyifan.communityback.service.IBmsPromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/promotion")
public class BmsPromotionController extends BaseController{

    @Resource
    private IBmsPromotionService bmsPromotionService;

    @GetMapping("/show")
    public ApiResult<List<BmsPromotion>> getNotices(){
        List<BmsPromotion> list = bmsPromotionService.list();
        return ApiResult.success(list);
    }

}
