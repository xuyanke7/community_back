package com.xuyifan.communityback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuyifan.communityback.mapper.BmsBillbaordMapper;
import com.xuyifan.communityback.mapper.BmsTipMapper;
import com.xuyifan.communityback.model.entity.BmsBillboard;
import com.xuyifan.communityback.model.entity.BmsTip;
import com.xuyifan.communityback.service.IBmsBillboardService;
import com.xuyifan.communityback.service.IBmsTipService;
import org.springframework.stereotype.Service;

@Service
public class IBmsTipServiceImpl extends ServiceImpl<BmsTipMapper, BmsTip>
        implements IBmsTipService {

    @Override
    public BmsTip getRandomTip() {
        return this.baseMapper.getRandomTip();
    }
}
