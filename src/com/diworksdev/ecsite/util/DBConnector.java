package com.diworksdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// MySQL接続に必要な情報を設定します。
public class DBConnector {
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/ecsite";
    private static String user = "root";
    private static String password = "mysql";

    public Connection getConnection() {
        Connection con = null;

        // 接続情報から自分のパソコンにインストールされているMySQLへ接続する準備が整います。
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // ドライバクラスが見つからない場合のエラー処理
            e.printStackTrace();
        } catch (SQLException e) {
            // SQLエラーが発生した場合のエラー処理
            e.printStackTrace();
        }
        // データベース接続を返します。
        return con;
    }
}
