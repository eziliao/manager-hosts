package com.chengli.managerhosts.core.command;

import com.chengli.managerhosts.core.exception.CommandException;

/**
 * 追加hosts文件命令
 *
 * @author ChengLi
 * @date 2021/11/12 13:30
 */
public class AppendRowHostsCommand implements Command {

    /**
     * 命令内容
     *
     * @return
     */
    @Override
    public String build(String... options) {
        if (options == null || options.length != 1) {
            throw new CommandException("AppendHostsCommand 命令构建错误，参数必传");
        }
        return "echo " + options[0] + " >> /etc/hosts";
    }
}
