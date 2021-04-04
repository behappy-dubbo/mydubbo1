package org.xiaowu.service.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;

/**
 * <p>
 * 会议-会议基础
 * </p>
 *
 * @author mrzhaowy
 * @since 2020-10-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("m_base_info")
public class MBaseInfo extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("code")
    private String code;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField(value = "user_id", jdbcType = JdbcType.BIGINT)
    private Long userId;

    @TableField("status")
    private Integer status;

    @TableField(exist = false)
    private UBaseInfo user;
}
