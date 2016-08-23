package com.smallclover.db;

import java.sql.*;

/**
 * Created by smallclover on 2016/8/23.
 */
public class DbCURD {

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet rs = null;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.home") +"\\360ChromePicture\\sqlite\\smallclover.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(20);//set timeout to 30 sec.

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库连接
     * @return
     */
    public static boolean close(){

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }

        return false;
    }

    /**
     * 根据图片名字查询
     * @param picName
     * @return
     */
    public static boolean queryByName(String picName){
        try {
            rs = statement.executeQuery("select * from picture where name = '"+picName+"'");
            if (rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  false;
    }

    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.home"));

        boolean flag = DbCURD.queryByName("0f133f36d5636efc6fdeae2f5630853fx");
        System.out.println(flag);
    }
}
