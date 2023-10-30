package com.myxh.smart.planet.model.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "Mq重复记录")
@TableName("mq_repeat_record")
public class MqRepeatRecord extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "业务编号")
    @TableField("business_no")
    private String businessNo;
}