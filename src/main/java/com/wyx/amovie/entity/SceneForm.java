package com.wyx.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wyx
 * @date 2019-08-26 16:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SceneForm {
    private Integer id;
    private Integer movieId;
    private String movieName;
    private Integer price;
    private Integer seatNum;
    private String showtime;
    private String[] bookedSeat;
}
