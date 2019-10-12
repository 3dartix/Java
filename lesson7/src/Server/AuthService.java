package Server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static String getIdByNick(String nick) throws SQLException {
        String sql = String.format("SELECT id FROM main where nickname = '%s'", nick);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()) {
            return rs.getString(1); //индексанция начинается с 1 (столбик)
        }
        return null;
    }

    public static List<String> getArrBlackList(String id) throws SQLException {
        List<String> blackList = new ArrayList<>();
        String sql = String.format("SELECT * FROM blackList where id = '%s'", id);
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            blackList.add(rs.getString(2));
        }
        return blackList;
    }

    public static void addUserToBlackList (String id, String nick) throws SQLException {
        String sql = String.format("INSERT INTO blackList (id, users) VALUES ('%s','%s')", id,nick);
        stmt.execute(sql);
    }


    public static void Disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
