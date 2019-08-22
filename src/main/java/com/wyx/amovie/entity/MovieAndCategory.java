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
public class MovieAndCategory {

    private Integer id;
    private Integer movieId;
    private Integer categoryId;
}
