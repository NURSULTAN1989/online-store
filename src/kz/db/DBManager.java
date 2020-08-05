package kz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/store?useUnicode=true&serverTimezone=UTC", "root", "");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Items> getAllItems(){
        ArrayList<Items> items=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM items");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                items.add(new Items(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
    public static Items getItem(Long id){
        Items items=null;
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM items WHERE id=?");
            statement.setLong(1,id);
            ResultSet resultSet=statement.executeQuery();


            if(resultSet.next()){

                items = new Items(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")
                );

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }
}
