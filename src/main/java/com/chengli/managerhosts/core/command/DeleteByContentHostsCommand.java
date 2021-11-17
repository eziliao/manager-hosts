package com.chengli.managerhosts.core.command;

import com.chengli.managerhosts.core.exception.CommandException;

/**
 * 根据内容删除
 *
 * @author ChengLi
 * @date 2021/11/12 13:30
 */
public class DeleteByContentHostsCommand implements Command {

    /**
     * 命令内容
     *
     * @return
     */
    @Override
    public String build(String... options) {
        if (options == null || options.length != 1) {
            throw new CommandException("DeleteByLineHostsCommand 命令构建错误，必须要传删除的内容");
        }
        return "sed -i '/^" + options[0] + "/d' /etc/hosts";
    }
}
