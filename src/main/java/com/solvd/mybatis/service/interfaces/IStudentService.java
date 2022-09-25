package com.solvd.mybatis.service.interfaces;

import com.solvd.mybatis.Student;
import com.solvd.mybatis.service.interfaces.IBase;

import java.util.List;

public interface IStudentService extends IBase<Student> {
    List<Student> selectAll();
}
