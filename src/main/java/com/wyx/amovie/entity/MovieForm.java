package com.wyx.amovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wyx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieForm {
    private Integer id;
    private String name;
    private String duration;
    private String directors;
    private String actors;
    private Date releaseDate;
    private Integer[] categoryIds;
    private Integer status;
    private String plot;
    private String poster;
    private String country;
}
