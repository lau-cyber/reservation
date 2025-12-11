package com.cpt202a19.reservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class ReservationApplicationTests {
	/** Test whether the database is connected */
    @Autowired // automatic assembly
    private DataSource dataSource;

    @Test
	void contextLoads() {}

	/** Hikari manages database connection objects */
	@Test
	void getConnection() throws SQLException {
		System.out.println(dataSource.getConnection());
	}

}
