import org.junit.jupiter.api.Test;

import java.sql.*;

class DataBaseConnectionTest {

    @Test
    void connection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2-jdbc", "hoseok", "1234");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("show databases");

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
