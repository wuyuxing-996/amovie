package com.wyx.amovie.entity;

import com.wyx.amovie.utils.Result;
import org.junit.Test;

public class ResultTest {

    @Test
    public void checkObject() {
        Category category = new Category(1, "sex");
        System.out.println(Result.checkObject(category));
    }
}