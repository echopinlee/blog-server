package com.jambo.entity.vo;

import lombok.Data;

/**
 * 推荐博客显示数据
 */
@Data
public class RecommendBlog {

    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;

}