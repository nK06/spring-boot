package com.panther.demo;

import com.panther.demo.entities.Employee;
import com.panther.demo.kafka.KafkaSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }


    /**
     * kafkaSender Test
     */
    @Autowired
    private KafkaSender<Employee> kafkaSender;

    @Test
    public void kafkaSend() throws InterruptedException {
        for(int i = 0 ; i < 5 ;i++){
            Employee employee = new Employee();
            employee.setLastname("AAA__" + i);
            employee.setBirth(new Date(new java.util.Date().getTime()));
            employee.setDepartmentId(i);
            kafkaSender.send(employee);
            Thread.sleep(3000);
        }
    }

}
