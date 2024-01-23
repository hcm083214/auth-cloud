package com.auth.cloud.permission.convert;

import com.auth.cloud.permission.pojo.po.RolePo;
import com.auth.cloud.permission.pojo.vo.respvo.RoleRespVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author 黄灿民
 * @date 2024/01/21
 */
@Mapper
public interface RoleConvert {

    RoleConvert  INSTANCE = Mappers.getMapper(RoleConvert.class);

    RoleRespVo poToVo(RolePo rolePo);
}
