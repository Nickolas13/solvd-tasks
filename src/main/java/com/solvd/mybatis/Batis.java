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
        Student student = new Student("harry", "TX", 25, 654231, "harry@gmial.com");

        //select all students
//        selectAll(session);
//        close(session);


        //Inserting student data
//        insert(session, student);
//        close(session);


        //Updating elements
        //get target element by id
//        Student student1 = (Student) session.selectOne("Student.getById", 2);
//        System.out.println("current details of student");
//        System.out.println(student1);

        //Update element details
//        student1.setName("william");
//        student1.setEmail("william@gmail.com");
//        student1.setPhone(87934321);
//        session.update("Student.update", student1);
//        System.out.println("updated successfully");
//        close(session);

        //Deleting elements
        session.delete("Student.deleteById", 3);
        close(session);
        System.out.println("Deleted element");
    }


}
