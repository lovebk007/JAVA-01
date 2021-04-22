package com.spring.jdbc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/16 17:42
 **/
@Data
@Builder
@ApiModel(description = "学生信息返回参数")
public class StudentInfoResDto {

    @ApiModelProperty(value = "学生ID")
    private Integer studentId;

    @ApiModelProperty(value = "学生名称")
    private String studentName;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "年龄")
    private Integer age;
}
