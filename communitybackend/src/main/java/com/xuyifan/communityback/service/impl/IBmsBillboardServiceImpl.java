package com.xuyifan.communityback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuyifan.communityback.mapper.BmsBillbaordMapper;
import com.xuyifan.communityback.model.entity.BmsBillboard;
import com.xuyifan.communityback.service.IBmsBillboardService;
import org.springframework.stereotype.Service;

@Service
public class IBmsBillboardServiceImpl extends ServiceImpl<BmsBillbaordMapper, BmsBillboard>
        implements IBmsBillboardService {

}
