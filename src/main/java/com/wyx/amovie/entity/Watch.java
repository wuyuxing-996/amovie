package com.wyx.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wyx
 * @date 2019-08-28 19:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Watch {

    private Integer id;
    private Integer userId;
    private Integer movieId;
    private Date createTime;
}
