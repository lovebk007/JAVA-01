package com.spring.jdbc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/16 14:12
 **/
@Data
@ApiModel(description = "学生信息请求参数")
public class StudentInfoReqDto {

    @ApiModelProperty(value = "学生ID", dataType = "Integer", example = "0")
    private Integer studentId;

    @ApiModelProperty(value = "学生名称", dataType = "String", example = "kkk")
    private String studentName;

    @ApiModelProperty(value = "性别: 男、女", dataType = "String", example = "女")
    private String gender;

    @ApiModelProperty(value = "年龄", dataType = "Integer", example = "20")
    private Integer age;

    @ApiModelProperty(value = "数据库操作模式开关 0-Hikari,1-Jdbc,2-PreparedStatement,3-Statement"
            , dataType = "Integer", example = "0", required = true)
    @NonNull
    private Integer switchButton;
}
