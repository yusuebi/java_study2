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
            // STEP 1 データベースの接続
            con = DriverManager.getConnection("jdbc:h2:~/rpgdb");

            // STEP 2-(2)-1 送信すべきSQLの雛形を準備
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MONSTERS WHERE HP >= ?");

            // STEP 2-(2)-2 ひな形に値を流し込みSQLを組み立て送信する
            pstmt.setInt(1, 10);
            ResultSet rs = pstmt.executeQuery();

            // STEP 2-(2)-3 結果表を処理する
            while(rs.next()) {
                System.out.println(rs.getString("NAME"));
            }
            rs.close();
            pstmt.close();

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            // STEP 3 データベース接続の切断
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
