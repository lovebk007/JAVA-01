package com.spring.jdbc.service;

import com.spring.jdbc.dto.StudentInfoReqDto;
import com.spring.jdbc.entity.Student;
import lombok.NonNull;

import java.util.List;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/16 14:01
 **/
public interface StudentInfoDao {

    /**
     * 查询
     * @param studentInfoReqDto
     * @return
     */
    List<Student> queryStudentInfoList(StudentInfoReqDto studentInfoReqDto);

    /**
     * 根据ID删除
     * @param studentId
     */
    void deleteById(@NonNull Integer studentId);

    /**
     * 保存
     * @param studentInfoReqDto
     */
    void save(StudentInfoReqDto studentInfoReqDto);

    /**
     * 更新
     * @param studentInfoReqDto
     */
    void update(StudentInfoReqDto studentInfoReqDto);

}
