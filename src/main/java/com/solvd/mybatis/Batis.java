package com.solvd.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.List;

public class Batis {
    static void selectAll(SqlSession session) {
        List<Student> students = session.selectList("Student.getAll");

        for (Student st : students) {
            System.out.println(st.getId() + " : " +
                    st.getName() + " : " +
                    st.getBranch() + " : " +
                    st.getPercentage() + " : " +
                    st.getEmail() + " : " +
                    st.getPhone());
        }
        System.out.println("Printed out records");
    }

    static void insert(SqlSession session, Student student) {
        session.insert("Student.insert", student);
        System.out.println("successfully inserted");
    }

    static void close(SqlSession session) {
        session.commit();
        session.close();
    }

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //Creating student object
        Student student = new Student("jonathan", "RE", 78, 325461, "jonathan@gmial.com");

        //select all students
        selectAll(session);


        //Inserting student data
        insert(session, student);
        close(session);

        //updating elements

        session.update();


        //deleting elements
//        session.delete();
    }


}
