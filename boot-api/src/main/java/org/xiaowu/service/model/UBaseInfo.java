package org.xiaowu.service.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("u_base_info")
public class UBaseInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("user_name")
    private String userName;

    @TableField("mobile")
    private String mobile;

    @TableField(exist = false)
    private String info;
}
