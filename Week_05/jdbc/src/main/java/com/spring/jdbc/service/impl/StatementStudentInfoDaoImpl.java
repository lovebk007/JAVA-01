package com.spring.jdbc.service.impl;

import com.spring.jdbc.dto.StudentInfoReqDto;
import com.spring.jdbc.entity.Student;
import com.spring.jdbc.enums.GenderTypeEnum;
import com.spring.jdbc.service.StudentInfoDao;
import com.spring.jdbc.utils.JdbcConnectionUtil;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/16 15:19
 **/
@Repository(value = "StatementStudentInfo")
public class StatementStudentInfoDaoImpl implements StudentInfoDao {

    /**
     * 查询
     * @param studentInfoReqDto
     * @return
     */
    @Override
    public List<Student> queryStudentInfoList(StudentInfoReqDto studentInfoReqDto) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            conn = JdbcConnectionUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from test.student");

            while (rs.next()) {
                list.add(new Student(rs.getInt("student_id")
                        , rs.getString("student_name")
                        , rs.getInt("gender")
                        , rs.getInt("age")));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectionUtil.release(conn, st, rs, null);
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
        Statement st = null;
        try {
            conn = JdbcConnectionUtil.getConnection();
            st = conn.createStatement();
            st.executeUpdate("delete from test.student where student_id = " + studentId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectionUtil.release(conn, st, null,null);
        }
    }

    /**
     * 保存
     * @param studentInfoReqDto
     */
    @Override
    public void save(StudentInfoReqDto studentInfoReqDto) {

        Connection conn = null;
        Statement st = null;
        try {
            conn = JdbcConnectionUtil.getConnection();
            st = conn.createStatement();
            String sql = "insert into test.student(student_name, gender, age) values" +
                    "('"+studentInfoReqDto.getStudentName()+"', " +
                    ""+GenderTypeEnum.getGenderByGenderTypeName(studentInfoReqDto.getGender())+", " +
                    ""+studentInfoReqDto.getAge()+" ";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectionUtil.release(conn, st, null, null);
        }
    }

    /**
     * 更新
     * @param studentInfoReqDto
     */
    @Override
    public void update(StudentInfoReqDto studentInfoReqDto) {

        Connection conn = null;
        Statement st = null;
        try {
            conn = JdbcConnectionUtil.getConnection();
            st = conn.createStatement();
            String sql = "update test.student set gender = '"+
                    GenderTypeEnum.getGenderByGenderTypeName(studentInfoReqDto.getGender())+"', age = "
                    +studentInfoReqDto.getAge()+" where student_id = " + studentInfoReqDto.getStudentId();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcConnectionUtil.release(conn, st, null, null);
        }
    }
}
