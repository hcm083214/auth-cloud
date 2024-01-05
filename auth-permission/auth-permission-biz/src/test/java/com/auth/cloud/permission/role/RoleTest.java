package com.auth.cloud.permission.role;


import com.auth.cloud.common.pojo.CommonResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 黄灿民
 * @date 2024/01/03
 */
@SpringBootTest
public class RoleTest {

    @Autowired
    public Role role;
    @Test
    public void roleTest() {
        CommonResult<String> role1 = role.getRole("角色");
        System.out.println("sssssss"+  role1.getData());
    }
}
