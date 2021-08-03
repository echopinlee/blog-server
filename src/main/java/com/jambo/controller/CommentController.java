package com.jambo.controller;


import com.jambo.common.lang.Result;
import com.jambo.entity.Comment;
import com.jambo.entity.User;
import com.jambo.entity.vo.DetailedBlog;
import com.jambo.service.BlogService;
import com.jambo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jambo
 * @since 2021-07-09
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;
    /**
     * 新增评论
      */
    @PostMapping("/comment")
    public Result post(Comment comment, HttpSession session) {
        Long blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            //设置头像
            comment.setAvatar(avatar);
        }

        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.save(comment);
//        List<Comment> comments = commentService.listCommentByBlogId(blogId);
//        model.addAttribute("comments", comments);
//        return "blog :: commentList";
        return Result.succ(null);
    }


    //    删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public Result delete(@PathVariable Long blogId, @PathVariable Long id, Comment comment){

//        return  commentService.removeById(id);
//        DetailedBlog detailedBlog = blogService.getDetailedBlog(blogId);
//        List<Comment> comments = commentService.listCommentByBlogId(blogId);
//        model.addAttribute("blog", detailedBlog);
//        model.addAttribute("comments", comments);
        return commentService.removeById(id) ? Result.ok() : Result.fail("操作失败")  ;

    }


}
