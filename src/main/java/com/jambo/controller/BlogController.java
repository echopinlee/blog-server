package com.jambo.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jambo.common.lang.Result;
import com.jambo.entity.po.Blog;
import com.jambo.service.BlogService;
import com.jambo.util.ShiroUtil;
import lombok.val;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器  查询的vo 需要继承page类
 * </p>
 *
 * @author jambo
 * @since 2021-07-09
 */
@RestController
@RequestMapping("/blog")
public class BlogController {


    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {

        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));

        return Result.succ(pageData);
    }

    /**
     * 获取博客详情
     * @param id
     * @return
     */
    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name = "id") Long id) {
        Blog blog = blogService.getById(id);
        //断言？
        Assert.notNull(blog, "该博客已被删除");
        return Result.succ(blog);
    }

    /**
     * 编辑或者添加
     * @param blog
     * @return
     */
    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog) {
//        Assert.isTrue(false, "公开版不能任意编辑！");
        Blog temp = null;
        if(blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            // 只能编辑自己的文章
            System.out.println(ShiroUtil.getProfile().getId());
            Assert.isTrue(temp.getUserId().longValue() == ShiroUtil.getProfile().getId().longValue(), "没有权限编辑");
        } else {
            temp = new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreateTime(LocalDateTime.now());
        }
        //需要创建status字段
        BeanUtil.copyProperties(blog, temp, "id", "userId", "createTime", "status");//把blog的属性复制到temp 中 后面的是忽略的属性，不复制的属性
        blogService.saveOrUpdate(temp);
        return Result.succ(null);
    }


    /**
     * 删除文章
     * @param id
     * @param blogReq
     * @return
     */
    @PostMapping("/delete")
    public Result delete(@PathVariable Long id, @RequestBody @Validated Blog blogReq ) {
        return blogService.delete(blogReq.getId()) ? Result.ok() : Result.fail("操作失败")  ;
    }


    //    搜索博客
//    @PostMapping("/blogs/search")
//    public String search(SearchBlog searchBlog, Model model,
//                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
//        List<BlogQuery> blogBySearch = blogService.getBlogBySearch(searchBlog);
//        PageHelper.startPage(pageNum, 10);
//        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogBySearch);
//        model.addAttribute("pageInfo", pageInfo);
//        return "admin/blogs :: blogList";
//    }







}
