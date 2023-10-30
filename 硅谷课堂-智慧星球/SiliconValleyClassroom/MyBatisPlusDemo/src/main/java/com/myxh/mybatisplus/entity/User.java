package com.myxh.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@Component
@Data
public class User
{
    // @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 逻辑删除标志
    @TableLogic
    private Integer deleted;
}
