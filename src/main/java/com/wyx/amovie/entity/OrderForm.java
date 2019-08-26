package com.wyx.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wyx
 * @date 2019-08-24 17:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
    private Integer id;
    private Integer status;
    private Integer userId;
    private Date createTime;
    private Integer sceneId;
    private String ticketNum;
    private Float totalPrice;
    private String seat;
}
