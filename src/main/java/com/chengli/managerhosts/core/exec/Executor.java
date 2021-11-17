package com.chengli.managerhosts.core.exec;

import com.chengli.managerhosts.core.command.Command;
import com.jcraft.jsch.Session;

/**
 * 执行器
 *
 * @author ChengLi
 * @date 2021/11/12 13:41
 */
public interface Executor {

    /**
     * 执行
     *
     * @param session
     * @param command
     * @param options
     * @return
     */
    String exec(Session session, Command command, String... options);
}
