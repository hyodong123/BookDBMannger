package BookDBMannger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete {

    public void deleteBook(String id) {
        Connection conn = getDBConnection();
        if (conn != null) {
            PreparedStatement pstmt = null;

            String sql = "DELETE FROM book WHERE id = ?";

            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);

                int result = pstmt.executeUpdate();
                if (result > 0) {
                    System.out.println(result + "행이 삭제되었습니다.");
                } else {
                    System.out.println("삭제된 행이 없습니다.");
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
