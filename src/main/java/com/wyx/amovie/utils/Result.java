package com.wyx.amovie.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author wyx
 * @date 2019-08-24 17:28
 */
public class Result {

    /**
     * 检查添加结果
     *
     * @param result
     * @return
     */
    public static ResponseEntity checkAdd(Integer result) {
        if (result != 0) {
            return ResponseEntity.ok("增加成功！");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * 检查删除结果
     *
     * @param result
     * @return
     */
    public static ResponseEntity checkDelete(Integer result) {
        if (result != 0) {
            return ResponseEntity.ok("删除成功！");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * 检查修改结果
     *
     * @param result
     * @return
     */
    public static ResponseEntity checkUpdate(Integer result) {
        if (result != 0) {
            return ResponseEntity.ok("修改成功！");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * 检查对象是否为空
     *
     * @param result
     * @return
     */
    public static <T> ResponseEntity checkObject(T result) {
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
