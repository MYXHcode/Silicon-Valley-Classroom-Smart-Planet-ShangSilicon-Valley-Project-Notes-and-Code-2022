package com.myxh.smart.planet.model.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class BaseMongoEntity implements Serializable
{

    @Schema(description = "ID")
    @Id
    private String id;

    @Schema(description = "创建时间")
    @CreatedDate
    private Date createTime;

    @Schema(description = "更新时间")
    @LastModifiedDate
    private Date updateTime;

    @Schema(description = "其他参数")
    // 被该注解标注的，将不会被录入到数据库中，只作为普通的 JavaBean 属性
    @Transient
    private Map<String, Object> param = new HashMap<>();
}
