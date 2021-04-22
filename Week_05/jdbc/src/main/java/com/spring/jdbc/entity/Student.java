package com.spring.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/15 18:26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private Integer studentId;

    private String studentName;

    private Integer gender;

    private Integer age;
}
