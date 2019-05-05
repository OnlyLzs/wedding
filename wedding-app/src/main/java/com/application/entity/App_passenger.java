package com.application.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * app旅客表
 * </p>
 *
 * @author Jason
 * @since 2019-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class App_passenger implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("mobile")
    private String mobile;

    /**
     * 身份证号
     */
    @TableField("identity_card")
    private String identity_card;

    /**
     * 护照号
     */
    @TableField("passport")
    private String passport;

    /**
     * 归属用户
     */
    @TableField("user_id")
    private Integer user_id;

    
    @TableField(exist=false)
    private App_user appUser;

    @TableField(value="create_time")
    private LocalDateTime create_time;

    @TableField(value = "update_time",update="now()")
    private LocalDateTime update_time;


}
