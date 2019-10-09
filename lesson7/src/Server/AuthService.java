package Server;

import java.sql.*;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void Connect(){
        try {
            Class.forName("org.sqlite.JDBC"); //выбираем драйвер
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db"); //инициализация
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String pass) throws SQLException {
        String sql = String.format("SELECT nickname FROM main where login = '%s' and password = '%s'", login, pass);

        ResultSet rs = stmt.executeQuery(sql);

        if(rs.next()) {
            return rs.getString(1); //индексанция начинается с 1 (столбик)
        }

        return null;
    }


    public static void Disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
