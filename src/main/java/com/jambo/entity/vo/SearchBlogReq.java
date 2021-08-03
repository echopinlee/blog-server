package com.jambo.entity.vo;

import lombok.Data;

/**
 * 搜索入参
 */
@Data
public class SearchBlogReq {

    private String title;
    private Long typeId;


}