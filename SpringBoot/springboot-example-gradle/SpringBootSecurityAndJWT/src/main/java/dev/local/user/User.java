package dev.local.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;
import java.util.List;

/**
 * 第1步:
 *lombok是用来简化POJO的创建的一个类库。
 * 简单说一下,采用 lombok 提供的 @Data 修饰符后可以简写成,
 * 原来的一坨getter和setter以及constructor等都不需要写了。
 *
 */

/**
 * 使用lombok在Intellij 中需要做如下设置,否则会报错
 * Setting 搜索Compiler 找到Annotation Processors 选择Enable annotation processing.
 * 选中，clean后再次编译即可
 */

@Data
public class User {
    @Id
    private String id;

    //MongoDB声明此字段为唯一索引
    @Indexed(unique=true, direction= IndexDirection.DESCENDING, dropDups=true)
    private String username;

    private String password;
    private String email;
    private Date lastPasswordResetDate;
    private List<String> roles;

}
