package com.chengli.managerhosts.core.exception;

/**
 * @author ChengLi
 * @date 2021/11/12 13:34
 */
public class CommandException extends RuntimeException {
    public CommandException() {
        super();
    }

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
