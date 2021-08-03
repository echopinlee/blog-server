package com.jambo.service.impl;

import com.jambo.entity.po.Message;
import com.jambo.mapper.MessageMapper;
import com.jambo.service.MessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
