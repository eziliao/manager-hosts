package com.chengli.managerhosts.core.command;

/**
 * 查看hosts文件命令
 *
 * @author ChengLi
 * @date 2021/11/12 13:30
 */
public class CatHostsCommand implements Command {

    /**
     * 命令内容
     *
     * @return
     */
    @Override
    public String build(String ...options) {
        return "cat /etc/hosts";
    }
}
