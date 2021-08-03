package com.jambo.service.impl;

import com.jambo.entity.po.Blog;
import com.jambo.mapper.BlogMapper;
import com.jambo.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {


    @Override
    public boolean delete(Long id) {
        int deleteResult = baseMapper.deleteById(id);
        return deleteResult>0 ? true :false;
    }
}
