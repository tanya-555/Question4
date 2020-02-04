package Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

class ConnectionConfiguration {

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/items?serverTimezone=UTC";

    private static Statement st;
    private static ResultSet rs;
    private static Connection connection = null;
    private static ArrayList<Item> itemlist = new ArrayList<Item>();

    public static Connection isConnected() {

        return connection;
    }

    public static ArrayList<Item> getConnection() {
        try {

            //obtaining connection to database through jdbc driver

            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, "root", "");
            st = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String query = "Select * from item";
            rs = st.executeQuery(query);
            while (rs.next()) {
                Item item = new Item();
                item.setName(rs.getString("item_name"));
                item.setPrice(rs.getDouble("price"));
                item.setQuantity(rs.getInt("quantity"));
                item.setType(rs.getString("type"));
                itemlist.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemlist;
    }
}