/*
 * Copyright (c) 2022. 李冲. All rights reserved.
 */

package work.lichong.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "人员")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;

}
