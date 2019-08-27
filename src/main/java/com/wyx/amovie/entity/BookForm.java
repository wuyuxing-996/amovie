package com.wyx.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wyx
 * @date 2019-08-27 10:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {
    //第一次提交
    private Integer choosenMovieId;
    private String choosenMovie;
    private String choosenTime;
    private String choosenDate;
    private Integer choosenScene;
    private String choosenCity;
    private String choosenCinema;
    private Integer choosenPrice;

    //第二次提交
    private Integer choosenNumber;
    private Integer choosenNumberCheap;
    private Integer choosenNumberMiddle;
    private Integer choosenNumberExpansive;
    private Integer choosenCost;
    private String choosenSits;
}
