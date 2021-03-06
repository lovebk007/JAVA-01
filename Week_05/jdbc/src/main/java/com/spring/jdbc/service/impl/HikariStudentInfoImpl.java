package com.spring.jdbc.service.impl;

import com.spring.jdbc.dto.StudentInfoReqDto;
import com.spring.jdbc.entity.Student;
import com.spring.jdbc.enums.GenderTypeEnum;
import com.spring.jdbc.service.StudentInfoDao;
import com.spring.jdbc.utils.JdbcConnectionUtil;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/16 17:51
 **/
@Repository(value = "HikariStudentInfo")
public class HikariStudentInfoImpl implements StudentInfoDao {

    @Resource
    private HikariDataSource hikariDataSource;


    /**
     * 查询
     * @param studentInfoReqDto
     * @return
     */
    @Override
    public List<Student> queryStudentInfoList(StudentInfoReqDto studentInfoReqDto) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            conn = hikariDataSource.getConnection();
            ps = conn.prepareStatement("select * from student");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(rs.getInt("student_id")
                        , rs.getString("student_name")
                        , rs.getInt("gender")
                        , rs.getInt("age")));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectionUtil.release(conn, null, rs, ps);
        }
        return list;
    }

    /**
     * 根据ID删除
     * @param studentId
     */
    @Override
    public void deleteById(@NonNull Integer studentId) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = hikariDataSource.getConnection();
            ps = conn.prepareStatement("delete from student where student_id = ?");
            ps.setInt(1, studentId);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectionUtil.release(conn, null, null, ps);
        }

    }

    /**
     * 保存
     * @param studentInfoReqDto
     */
    @Override
    public void save(StudentInfoReqDto studentInfoReqDto) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = hikariDataSource.getConnection();
            ps = conn.prepareStatement("insert into student (student_name, gender, age) values (?,?,?)");
            ps.setString(1, studentInfoReqDto.getStudentName());
            ps.setInt(2, GenderTypeEnum.getGenderByGenderTypeName(studentInfoReqDto.getGender()));
            ps.setInt(3, studentInfoReqDto.getAge());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectionUtil.release(conn, null, null, ps);
        }

    }

    /**
     * 更新
     * @param studentInfoReqDto
     */
    @Override
    public void update(StudentInfoReqDto studentInfoReqDto) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = hikariDataSource.getConnection();
            ps = conn.prepareStatement("update student set gender = ?, age = ? where student_id = ?");
            ps.setInt(1, GenderTypeEnum.getGenderByGenderTypeName(studentInfoReqDto.getGender()));
            ps.setInt(2, studentInfoReqDto.getAge());
            ps.setInt(3, studentInfoReqDto.getStudentId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectionUtil.release(conn, null, null, ps);
        }
    }
}
