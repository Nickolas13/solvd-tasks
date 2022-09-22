package com.solvd.parsing.json;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.mvc.dao.mysql.CompanyDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Json {
    private static final Logger logger = LogManager.getLogger(Json.class);

    public static void main(String[] args) {
        read();
    }

    private static Staff createStaff() {
        Staff staff = new Staff();
        staff.setName("bobby");
        staff.setAge(45);
        staff.setPosition(new String[]{"Founder", "CEO", "Designer"});
        Map<String, BigDecimal> salary = new HashMap<>() {{
            put("2022", new BigDecimal(10000));
            put("2023", new BigDecimal(20000));
            put("2024", new BigDecimal(40000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "selenium", "carina"));
        return staff;
    }

    private static void read() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // JSON file to Java object
            Staff staff = mapper.readValue(new File("src/main/resources/jackson/staff.json"), Staff.class);

            // JSON string to Java object
            String jsonInString = "{\"name\":\"bobby\",\"age\":45,\"skills\":[\"java\",\"selenium\"]}";
            Staff staff2 = mapper.readValue(jsonInString, Staff.class);

            // compact print
            System.out.println(staff2);

            // pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);

            System.out.println(prettyStaff1);


        } catch (IOException e) {
            logger.error(e);
        }
    }

    private static void write() {
        ObjectMapper mapper = new ObjectMapper();
        Staff staff = createStaff();
        //Java to Json
        try {
            mapper.writeValue(new File("src/main/resources/jackson/staff.json"), staff);
            String jsonString = mapper.writeValueAsString(staff);
            System.out.println(jsonString);

            String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
            System.out.println(jsonString2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
