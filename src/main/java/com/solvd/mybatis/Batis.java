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

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //Creating student object
//        Student student = new Student("john", "it", 20, 654654, "john@gmial.com");

        //select all students
        List<Student> students = session.selectList("Student.getAll");

//        for (Student s : students) {
//            for (Field f : s.getClass().getFields()) {
//                System.out.println(f);
//            }
//        }
        for (Student st : students) {
            System.out.println(st.getId() + " : " +
                    st.getName() + " : " +
                    st.getBranch() + " : " +
                    st.getPercentage() + " : " +
                    st.getEmail() + " : " +
                    st.getPhone());
        }


        System.out.println("Printed out records");

        //Inserting student data
//        session.insert("Student.insert", student);
//        System.out.println("successfully inserted");


        session.commit();
        session.close();

    }
}
