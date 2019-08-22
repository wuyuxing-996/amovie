package com.wyx.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wyx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SceneVo {
    private Integer id;
    private Integer movieId;
    private String movieName;
    private Float price;
    private Integer seatNum;
    private String showtime;
    private String[] bookedSeat;
}
