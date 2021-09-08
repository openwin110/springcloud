package com.itheima.springcloud.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
//与数据库表名对应
@Table(name = "payment")
public class Payment implements Serializable {
    @Id
    //开启主键自动回填
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String serial;
}
