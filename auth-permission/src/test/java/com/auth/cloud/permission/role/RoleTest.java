package com.auth.cloud.permission.role;


import com.auth.cloud.common.pojo.CommonResult;
import com.auth.cloud.permission.controller.RoleController;
import com.auth.cloud.permission.mapper.RoleMapper;
import com.auth.cloud.permission.pojo.po.RolePo;
import com.auth.cloud.permission.pojo.vo.respvo.RoleRespVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@SpringBootTest
@Slf4j
public class RoleTest {

    @Autowired
    private RoleController roleController;

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void roleTest() {
        CommonResult<String> role1 = roleController.testI18n("角色");
        log.info("role1:{}", role1);
    }

    @Test
    public void testRoleById() {
//        CommonResult<RoleRespVo> role1 = roleController.getRoleById(1L);
//        log.info("testRoleById:{}", role1);

//        RolePo rolePo = roleMapper.selectById(1L);
//        log.info("rolePo:{}", rolePo);
        List<RolePo> rolePos = roleMapper.selectList(null);
        rolePos.forEach(System.out::println);
    }
}
