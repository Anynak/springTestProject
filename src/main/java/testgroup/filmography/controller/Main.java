package testgroup.filmography.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
        public static void main(String[] args) {
            String url = "bwhguqew8rnzful6ssam-mysql.services.clever-cloud.com:3306";
            String username = "uxyiz4ggdkrmuqwy";
            String password = "PCcsoxRBcTD8Dy0BrCGB";
            String dmName = "bwhguqew8rnzful6ssam";
            String connectionString = "jdbc:mysql://" + url + "/" + dmName + "?useUnicode=true&characterEncoding=utf8";

            System.out.println("Connecting...");

            try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {
                System.out.println("Connection successful!");
            } catch (SQLException e) {
                System.out.println("Connection failed!");
                e.printStackTrace();
            }
        }
    }

