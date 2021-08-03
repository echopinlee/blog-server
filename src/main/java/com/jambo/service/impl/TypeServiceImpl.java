package com.jambo.service.impl;

import com.jambo.entity.po.Type;
import com.jambo.mapper.TypeMapper;
import com.jambo.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jambo
 * @since 2021-07-09
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}
