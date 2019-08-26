package com.wyx.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wyx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scene {
    private Integer id;
    private Integer movieId;
    private String movieName;
    private Integer price;
    private Integer seatNum;
    private String showtime;
    private String bookedSeat;
}
