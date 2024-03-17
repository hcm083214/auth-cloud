package com.auth.cloud.permission.mapper;

import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黄灿民
 * @date 2024/03/17
 */
@Repository
public interface I18nResourceMapper extends BaseMapper<I18nResourcePo> {
    Integer insertBatchSomeColumn(List<I18nResourcePo> pos);
}
