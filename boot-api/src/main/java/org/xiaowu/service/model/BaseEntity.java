package org.xiaowu.service.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mrzhaowy
 * @create 2020-10-20 下午6:27
 **/
@Data
public class BaseEntity implements Serializable {

    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private String createUserId;

    @TableField(value = "create_user_name", fill = FieldFill.INSERT)
    private String createUserName;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    private String updateUserId;

    @TableField(value = "update_user_name", fill = FieldFill.INSERT_UPDATE)
    private String updateUserName;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "status", fill = FieldFill.INSERT)
    @TableLogic
    private Integer status;
}
