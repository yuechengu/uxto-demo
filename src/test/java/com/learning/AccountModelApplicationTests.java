package com.learning;

import com.google.common.hash.Hashing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;


@SpringBootTest
class AccountModelApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    @Test
    void sha256Test() {
        String hash = Hashing.sha256().hashString("testing", StandardCharsets.UTF_8).toString();
        System.out.println(hash);
    }

    @Test
    void sha1Test() {
        String hash = Hashing.sha1().hashString("testing", StandardCharsets.UTF_8).toString();
        System.out.println(hash);
    }

    @Test
    void sipHash24Test() {
        String hash = Hashing.sipHash24().hashString("testing", StandardCharsets.UTF_8).toString();
        System.out.println(hash);
    }


}
