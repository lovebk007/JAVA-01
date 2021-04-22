package com.spring.jdbc.service.impl;

import com.spring.jdbc.dto.StudentInfoReqDto;
import com.spring.jdbc.entity.Student;
import com.spring.jdbc.enums.GenderTypeEnum;
import com.spring.jdbc.service.StudentInfoDao;
import lombok.NonNull;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/16 15:20
 **/
@Repository(value = "JdbcTempStudentInfo")
public class JdbcTempStudentInfoImpl implements StudentInfoDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTempStudentInfoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询
     * @param studentInfoReqDto
     * @return
     */
    @Override
    public List<Student> queryStudentInfoList(StudentInfoReqDto studentInfoReqDto) {
        return jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<>(Student.class));

    }

    /**
     * 根据ID删除
     * @param studentId
     */
    @Override
    public void deleteById(@NonNull Integer studentId) {
        jdbcTemplate.update("delete from student where student_id = ?", studentId);
    }

    /**
     * 保存
     * @param studentInfoReqDto
     */
    @Override
    public void save(StudentInfoReqDto studentInfoReqDto) {
        jdbcTemplate.update("insert into student (student_name, gender, age) values (?,?,?)"
                ,studentInfoReqDto.getStudentName()
                ,GenderTypeEnum.getGenderByGenderTypeName(studentInfoReqDto.getGender())
                ,studentInfoReqDto.getAge()
        );
    }

    /**
     * 更新
     * @param studentInfoReqDto
     */
    @Override
    public void update(StudentInfoReqDto studentInfoReqDto) {
        jdbcTemplate.update("update student set gender = ?, age = ? where student_id = ?"
                , GenderTypeEnum.getGenderByGenderTypeName(studentInfoReqDto.getGender())
                ,studentInfoReqDto.getAge()
                ,studentInfoReqDto.getStudentId());
    }
}
