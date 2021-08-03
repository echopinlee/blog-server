package com.jambo.mapper;

import com.jambo.entity.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jambo
 * @since 2021-07-09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
