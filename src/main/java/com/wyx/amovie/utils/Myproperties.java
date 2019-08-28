package com.wyx.amovie.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wyx
 * @date 2019-08-28 09:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Myproperties {

    @Value(value = "${filepath}")
    private String filepath;

}
