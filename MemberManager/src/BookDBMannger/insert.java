package BookDBMannger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {

    public void insertBook(String id, String title, String author, String publisher, int price) {
        Connection conn = getDBConnection();
        if (conn != null) {
            PreparedStatement pstmt = null;

            String sql = "INSERT INTO book (id, title, author, publisher, price) "
                    + "VALUES (?, ?, ?, ?, ?)";

            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.setString(2, title);
                pstmt.setString(3, author);
                pstmt.setString(4, publisher);
                pstmt.setInt(5, price);

                int result = pstmt.executeUpdate();
                if (result > 0) {
                    System.out.println(result + "행이 추가되었습니다.");
                }

                // 트랜잭션 커밋
                conn.commit();

            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    // 트랜잭션 롤백
                    if (conn != null) {
                        conn.rollback();
                    }
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
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
        } else {
            System.out.println("DB 연결 실패");
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
            // 자동 커밋 끄기
            conn.setAutoCommit(false);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
