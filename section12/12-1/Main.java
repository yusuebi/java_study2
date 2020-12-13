import java.sql.*;
public class Main {
    public static void main(String[] args) {

        // STEP 0: 事前準備
        try {
            Class.forName("org.h2.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            // STEP 1: データベースの接続
            con = DriverManager.getConnection("jdbc:h2:~/rpgdb");
            // STEP 2: 送信処理
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            // STEP 3: データベース接続の切断
            if(con != null) {
                try {
                  con.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
