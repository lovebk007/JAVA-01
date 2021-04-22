package com.spring.jdbc.manager;

import com.spring.jdbc.dto.StudentInfoReqDto;
import com.spring.jdbc.dto.StudentInfoResDto;
import com.spring.jdbc.entity.Student;
import com.spring.jdbc.enums.GenderTypeEnum;
import com.spring.jdbc.enums.SqlSwitchConfigEnum;
import com.spring.jdbc.service.StudentInfoDao;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/20 17:42
 **/
@Service
@Slf4j
public class StudentInfoManager {

    @Resource(name = "JdbcTempStudentInfo")
    private StudentInfoDao studentInfoDaoJdbc;

    @Resource(name = "StatementStudentInfo")
    private StudentInfoDao studentInfoDaoStatement;

    @Resource(name = "HikariStudentInfo")
    private StudentInfoDao studentInfoDaoHikari;

    @Resource(name = "PreparedStatementStudentInfo")
    private StudentInfoDao studentInfoDaoPrepared;


    /**
     * 查询
     * @param studentInfoReqDto
     * @return
     */
    public List<StudentInfoResDto> findAll(StudentInfoReqDto studentInfoReqDto){

        List<Student> studentList = new ArrayList<>();

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Hikari.getValue())){
            studentList = studentInfoDaoHikari.queryStudentInfoList(studentInfoReqDto);
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Jdbc.getValue())){
            studentList = studentInfoDaoJdbc.queryStudentInfoList(studentInfoReqDto);
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.PreparedStatement.getValue())){
            studentList = studentInfoDaoPrepared.queryStudentInfoList(studentInfoReqDto);
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Statement.getValue())){
            studentList = studentInfoDaoStatement.queryStudentInfoList(studentInfoReqDto);
        }

        return Optional.ofNullable(studentList)
                .orElseGet(ArrayList::new)
                .stream()
                .map(StudentInfoManager::infoResDto)
                .collect(Collectors.toList());
    }


    /**
     * 保存
     * @param studentInfoReqDto
     */
    public void save(StudentInfoReqDto studentInfoReqDto){

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Hikari.getValue())){
            studentInfoDaoHikari.save(studentInfoReqDto);
            return;
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Jdbc.getValue())){
            studentInfoDaoJdbc.save(studentInfoReqDto);
            return;
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.PreparedStatement.getValue())){
            studentInfoDaoPrepared.save(studentInfoReqDto);
            return;
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Statement.getValue())){
            studentInfoDaoStatement.save(studentInfoReqDto);
        }
    }


    /**
     * 更新
     * studentInfoReqDto
     * @param studentInfoReqDto
     */
    public void update(StudentInfoReqDto studentInfoReqDto){

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Hikari.getValue())){
            studentInfoDaoHikari.update(studentInfoReqDto);
            return;
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Jdbc.getValue())){
            studentInfoDaoJdbc.update(studentInfoReqDto);
            return;
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.PreparedStatement.getValue())){
            studentInfoDaoPrepared.update(studentInfoReqDto);
            return;
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Statement.getValue())){
            studentInfoDaoStatement.update(studentInfoReqDto);
        }
    }

    /**
     * 根据ID删除
     * @param studentInfoReqDto
     */
    public void deleteById(StudentInfoReqDto studentInfoReqDto){

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Hikari.getValue())){
            studentInfoDaoHikari.deleteById(studentInfoReqDto.getStudentId());
            return;
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Jdbc.getValue())){
            studentInfoDaoJdbc.deleteById(studentInfoReqDto.getStudentId());
            return;
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.PreparedStatement.getValue())){
            studentInfoDaoPrepared.deleteById(studentInfoReqDto.getStudentId());
            return;
        }

        if (studentInfoReqDto.getSwitchButton().equals(SqlSwitchConfigEnum.Statement.getValue())){
            studentInfoDaoStatement.deleteById(studentInfoReqDto.getStudentId());
        }
    }

    /**
     * 格式化
     * @param student
     * @return
     */
    private static StudentInfoResDto infoResDto(Student student){

        return StudentInfoResDto.builder()
                .studentId(student.getStudentId())
                .studentName(student.getStudentName())
                .gender(GenderTypeEnum.getGenderTypeNameByGender(student.getGender()))
                .age(student.getAge())
                .build();
    }
}
