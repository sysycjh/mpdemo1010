package com.cjh.mpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type = IdType.ID_WORKER) //自动填充 mp算法计算id
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //create_Time
    //执行插入语句时，为这个字段预留sql注入
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill=FieldFill.INSERT)
    private Integer version;

}