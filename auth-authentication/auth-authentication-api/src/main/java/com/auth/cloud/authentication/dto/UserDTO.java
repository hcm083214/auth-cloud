package com.auth.cloud.authentication.dto;

import com.auth.cloud.common.pojo.Base;
import lombok.Data;

@Data
public class UserDTO extends Base {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 状态 帐号状态（1正常 0停用）
     */
    private String status;

}
