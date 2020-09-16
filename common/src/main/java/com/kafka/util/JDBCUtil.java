package com.kafka.util;

import com.kafka.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
    private static Statement stmt = null;//静态方法在类加载的时候就加载，所以stmt必须是static 类型
    private static Connection connection = null;

    public static Integer  insert(User user){
        Integer result = null;
        try {
            //1.加载jdbc驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取远程mysql连接（url（主要用到的是ip+port+databaseName），user，password（主要用到的是phpMyadmin创建的可远程访问的用户的用户名和密码））
            String url = "jdbc:mysql://127.0.0.1:3306/kfk?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";//通过jdbx访问mysql数据库服务器，远程服务器ip为192.168.43.160 ，port为3306，数据库名称为 test
            //phpMyadmin中创建的可远程访问权限的用户的用户名和密码
            String ur = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url,ur,password);//jdbc 连接上mysql服务器上的test数据库了
            //3.开启sql称述，（Statement，PreparedStatement（？占位符形式）），执行sql语句
            stmt = connection.createStatement();
            String sql = "insert into tb_user(name,gender,age) values ('"+user.getName()+"','"+user.getGender()+"','"+user.getAge()+"')";
            result = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //6.对资源进行关闭(Resultset(此处没有)，stmt，connection（采用栈式关闭)) 不能放入一个try catch 中，因为若一个执行失败，则其余资源也无法关闭
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static List<User>  select(){
        List<User> result = new ArrayList<>();
        try {
            //1.加载jdbc驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取远程mysql连接（url（主要用到的是ip+port+databaseName），user，password（主要用到的是phpMyadmin创建的可远程访问的用户的用户名和密码））
            String url = "jdbc:mysql://127.0.0.1:3306/kfk?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";//通过jdbx访问mysql数据库服务器，远程服务器ip为192.168.43.160 ，port为3306，数据库名称为 test
            //phpMyadmin中创建的可远程访问权限的用户的用户名和密码
            String ur = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url,ur,password);//jdbc 连接上mysql服务器上的test数据库了
            //3.开启sql称述，（Statement，PreparedStatement（？占位符形式）），执行sql语句
            stmt = connection.createStatement();
            String sql = "select * from tb_user";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                User user = new User();
                Integer id= rs.getInt(1);
                String name = rs.getString(2);
                Integer gender= rs.getInt(3);
                Integer age= rs.getInt(4);
                user.setId(id);
                user.setAge(age);
                user.setGender(gender);
                user.setName(name);
                result.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //6.对资源进行关闭(Resultset(此处没有)，stmt，connection（采用栈式关闭)) 不能放入一个try catch 中，因为若一个执行失败，则其余资源也无法关闭
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
