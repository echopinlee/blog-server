package com.jambo.service.impl;

import com.jambo.entity.po.Comment;
import com.jambo.mapper.CommentMapper;
import com.jambo.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
