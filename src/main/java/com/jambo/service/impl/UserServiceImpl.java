package com.jambo.service.impl;

import com.jambo.entity.po.User;
import com.jambo.mapper.UserMapper;
import com.jambo.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
