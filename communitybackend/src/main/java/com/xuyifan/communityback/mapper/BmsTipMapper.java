package com.xuyifan.communityback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuyifan.communityback.model.entity.BmsBillboard;
import com.xuyifan.communityback.model.entity.BmsTip;
import org.springframework.stereotype.Repository;


@Repository
public interface BmsTipMapper extends BaseMapper<BmsTip> {
    BmsTip getRandomTip();
}
