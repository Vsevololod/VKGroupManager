package club.mytree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;


public class SQLiteConnection {
    private Connection connection;
    private Statement statement;

    SQLiteConnection(String dbName) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:data/" + dbName + ".db");
            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INTEGER, online INTEGER, time INTEGER)");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    boolean update(List<UserOnline> usersOnline) {
        long unixTime = System.currentTimeMillis() / 1000L;
        try {
            for (UserOnline user : usersOnline)
                statement.executeUpdate("insert into users values(" + user.id + ", " + user.online + ", " + unixTime + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    List<UserOnline> getAllData() {
        List<UserOnline> users = new LinkedList<>();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE time;");
            while (rs.next()) {
                users.add(new UserOnline(
                        rs.getInt("id"),
                        rs.getInt("online"),
                        rs.getInt("time")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    List<UsersOnline> getUsersOnline(int timeStart, int timeEnd) {
        List<UsersOnline> users = new LinkedList<>();
        try {
            Formatter f = new Formatter();
            f.format("SELECT users.time,SUM(users.online) AS num FROM users WHERE users.time > %d AND users.time < %d GROUP BY users.time;",timeStart,timeEnd);
            String q = f.toString();
            System.out.println(q);
            ResultSet rs = statement.executeQuery(q);
            while (rs.next()) {
                users.add(new UsersOnline(
                        rs.getInt("time"),
                        rs.getInt("num")
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}