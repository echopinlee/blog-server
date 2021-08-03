package com.jambo.entity.vo;

import com.jambo.entity.Type;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 显示数据实体类
 * @Author: ONESTAR
 * @Date: Created in 15:20 2020/3/31
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Data
public class BlogQuery {

    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;


}