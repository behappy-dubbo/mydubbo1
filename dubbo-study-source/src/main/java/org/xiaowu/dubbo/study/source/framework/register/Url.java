package org.xiaowu.dubbo.study.source.framework.register;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Url implements Serializable {

    private static final long serialVersionUID = 3574284138135147490L;
    String hostName;
    Integer port;
}
