import java.util.*;
import java.io.*;
import java.sql.*;

public class ItemDAO {
    public static ArrayList<Item> findByMinimumPrice(int i) {
        try {
            Class.forName("org.h2.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:h2:~/rpgdb");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ITEMS WHERE PRICE > ?");
            pstmt.setInt(1, i);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Item> items = new ArrayList<Item>();

            while(rs.next()) {
                Item item = new Item();
                item.setName(rs.getString("ANME"));
                item.setPrice(rs.getInt("PRICE"));
                item.setWeight(rs.getInt("WEGIHT"));
                items.add(item);
            }
            rs.close();
            pstmt.close();
            return items;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
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
