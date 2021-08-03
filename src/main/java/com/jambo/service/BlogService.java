package com.jambo.service;

import com.jambo.entity.po.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jambo
 * @since 2021-07-09
 */
public interface BlogService extends IService<Blog> {

    boolean delete(Long id);
}
