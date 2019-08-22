package com.wyx.amovie.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wyx
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageException extends Exception {

    private String message;
}