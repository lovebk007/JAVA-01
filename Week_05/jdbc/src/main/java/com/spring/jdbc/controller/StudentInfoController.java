package com.spring.jdbc.controller;

import com.spring.jdbc.dto.StudentInfoReqDto;
import com.spring.jdbc.dto.StudentInfoResDto;
import com.spring.jdbc.manager.StudentInfoManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jdbc -- chengyan
 * @date 2021/4/16 10:44
 **/
@Slf4j
@RestController
@Api(tags = "学生信息控制器")
public class StudentInfoController {

    @Resource private StudentInfoManager studentInfoManager;

    @ApiOperation(value = "学生信息查询")
    @PostMapping("/findAll")
    public List<StudentInfoResDto> findAll(StudentInfoReqDto studentInfoReqDto){
        return studentInfoManager.findAll(studentInfoReqDto);
    }

    @ApiOperation(value = "学生信息保存")
    @PostMapping("/save")
    public void save(StudentInfoReqDto studentInfoReqDto){
        studentInfoManager.save(studentInfoReqDto);
    }

    @ApiOperation(value = "学生信息更新")
    @PostMapping("/update")
    public void update(StudentInfoReqDto studentInfoReqDto){
        studentInfoManager.update(studentInfoReqDto);
    }

    @ApiOperation(value = "学生信息删除")
    @DeleteMapping("/delete")
    public void deleteById(StudentInfoReqDto studentInfoReqDto){
        studentInfoManager.deleteById(studentInfoReqDto);
    }
}
