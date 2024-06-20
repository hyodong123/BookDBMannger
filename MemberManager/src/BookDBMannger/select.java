package BookDBMannger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class select {

    public void selectBookById(String id) {
        Connection conn = getDBConnection();
        if (conn != null) {
            System.out.println("오라클 연결 성공");
        }
        PreparedStatement pstmt = null;

        String sql = "SELECT * FROM BOOK WHERE id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                System.out.println(result.getString("id") + " "
                        + result.getString("title") + " "
                        + result.getString("author") + " "
                        + result.getString("publisher") + " "
                        + result.getInt("price"));
            } else {
                System.out.println("해당 ID를 가진 책이 없습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    Connection getDBConnection() {
        final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String userid = "c##java";
        final String passwd = "181612";

        Connection conn = null;

        try {
            Class.forName(jdbcDriverClassName);
            conn = DriverManager.getConnection(url, userid, passwd);
            System.out.println("오라클 DB 연결 성공");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
