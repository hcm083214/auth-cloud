package com.auth.cloud.permission;

import com.auth.cloud.permission.mapper.I18nResourceMapper;
import com.auth.cloud.permission.pojo.po.I18nResourcePo;
import com.auth.cloud.permission.pojo.vo.reqvo.i18n.I18nSearchReqVo;
import com.auth.cloud.permission.service.I18nResourceService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class I18nResourceTest {

    @Autowired
    private I18nResourceService i18nResourceService;

    @Autowired
    private I18nResourceMapper i18nResourceMapper;

    @Test
    public void test(){
        I18nSearchReqVo reqVo = new I18nSearchReqVo();
        Page<I18nResourcePo> pageList = i18nResourceService.getI18nPageList(new Page<>(1, 10), reqVo);
        log.info("getCurrent:{}", pageList.getCurrent());
        log.info("getRecords:{}", pageList.getRecords());
        log.info("getTotal:{}", pageList.getTotal());
        log.info("getSize:{}", pageList.getSize());
        log.info("getPages:{}", pageList.getPages());

        Page<I18nResourcePo> page = i18nResourceMapper.selectPage(new Page<>(1, 3), null);
        log.info("getCurrent:{}", page.getCurrent());
        log.info("getRecords:{}", page.getRecords());
        log.info("getTotal:{}", page.getTotal());
        log.info("getSize:{}", page.getSize());
        log.info("getPages:{}", page.getPages());
    }
}
