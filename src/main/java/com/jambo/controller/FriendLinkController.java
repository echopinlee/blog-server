package com.jambo.controller;


import com.jambo.common.lang.Result;
import com.jambo.entity.FriendLink;
import com.jambo.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/friend-link")
public class FriendLinkController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public Result friends() {
        List<FriendLink> friendLinks = friendLinkService.list();
        return Result.succ(friendLinks);
    }


}
