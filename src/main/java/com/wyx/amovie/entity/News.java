package com.wyx.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wyx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private Integer id;
    private String content;
    private Date createTime;
}
