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
public class Scene {
    private Integer id;
    private Integer movieId;
    private String movieName;
    private Float price;
    private Integer seatNum;
    private Date showtime;
    private String bookedSeat;
}
