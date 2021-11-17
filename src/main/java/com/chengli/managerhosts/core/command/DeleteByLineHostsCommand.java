package com.chengli.managerhosts.core.command;

import com.chengli.managerhosts.core.exception.CommandException;

/**
 * 根据行号删除
 *
 * @author ChengLi
 * @date 2021/11/12 13:30
 */
public class DeleteByLineHostsCommand implements Command {

    /**
     * 命令内容
     *
     * @return
     */
    @Override
    public String build(String... options) {
        if (options == null || options.length != 1) {
            throw new CommandException("DeleteByLineHostsCommand 命令构建错误，必须且只能传一个行号");
        }
        try {
            Integer.parseInt(options[0]);
        } catch (Throwable e) {
            throw new CommandException("DeleteByLineHostsCommand 命令构建错误，行号错误，必须为整数");
        }
        return "sed -i '" + options[0] + "d' /etc/hosts";
    }
}
