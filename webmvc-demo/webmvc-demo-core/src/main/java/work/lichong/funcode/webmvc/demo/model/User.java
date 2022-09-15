/*
 * Copyright (c) 2022. 李冲. All rights reserved.
 */

package work.lichong.funcode.webmvc.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lichong
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@Data
@Schema(name = "人员")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @SchemaProperty(name = "姓名")
    private String name;
    @SchemaProperty(name = "年龄")
    private Integer age;

}
