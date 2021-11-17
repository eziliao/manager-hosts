package com.chengli.managerhosts.core.command;

/**
 * 执行命令
 *
 * @author ChengLi
 * @date 2021/11/12 13:28
 */
public interface Command {
    /**
     * 命令内容
     *
     * @return
     */
    String build(String... options);
}
