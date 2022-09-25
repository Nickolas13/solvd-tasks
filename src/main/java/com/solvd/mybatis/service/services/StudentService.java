package com.solvd.mybatis.service.services;

import com.solvd.mybatis.Student;
import com.solvd.mybatis.service.interfaces.IStudentService;
import com.solvd.mybatis.service.MyBatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

public class StudentService implements IStudentService {


    public void insert(Student student) {
        try {
            IStudentService mapper = getSession().getMapper(IStudentService.class);
            mapper.insert(student);
        } finally {
            close(getSession());
        }
    }

    @Override
    public void update(Student student, int id) {
        try {
            student.setId(id);
            IStudentService mapper = getSession().getMapper(IStudentService.class);
            mapper.update(student, id);
        } finally {
            close(getSession());
        }
    }

    public void delete(int id) {
        try {
            IStudentService mapper = getSession().getMapper(IStudentService.class);
            mapper.delete(id);
        } finally {
            close(getSession());
        }
    }

    public List<Student> selectAll() {
        try {
            IStudentService mapper = getSession().getMapper(IStudentService.class);
            return mapper.selectAll();
        } finally {
            close(getSession());
        }
    }


    public Student getById(int id) {
        try {
            IStudentService mapper = getSession().getMapper(IStudentService.class);
            return mapper.getById(id);
        } finally {
            close(getSession());
        }
    }


}
