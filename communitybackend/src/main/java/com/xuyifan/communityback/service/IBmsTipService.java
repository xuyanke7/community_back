package com.xuyifan.communityback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuyifan.communityback.mapper.BmsTipMapper;
import com.xuyifan.communityback.model.entity.BmsBillboard;
import com.xuyifan.communityback.model.entity.BmsTip;


public interface IBmsTipService extends IService<BmsTip> {
    BmsTip getRandomTip();
}
