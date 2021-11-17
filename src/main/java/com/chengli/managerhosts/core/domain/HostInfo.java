package com.chengli.managerhosts.core.domain;

import lombok.Data;

/**
 * 服务器信息
 *
 * @author ChengLi
 * @date 2021/11/12 13:19
 */
@Data
public class HostInfo {
    private String host;

    private Integer port = 22;

    private String user;

    private String password;
}
