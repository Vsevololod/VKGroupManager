package club.mytree;

import org.sqlite.SQLiteConfig;

import java.sql.*;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;


public class SQLiteConnection {
    private SQLiteConfig config = new SQLiteConfig();

    private Connection connection;


    SQLiteConnection(String dbName, boolean readOnly) {
        try {
            config.setReadOnly(readOnly);
            connection = DriverManager.getConnection("jdbc:sqlite:data/" + dbName + ".db",config.toProperties());
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INTEGER, online INTEGER, time INTEGER)");
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    boolean update(List<UserOnline> usersOnline) {
        String q = "INSERT INTO users VALUES(?,?,?)";
        long unixTime = System.currentTimeMillis() / 1000L;
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(q);
            for (UserOnline user : usersOnline) {
                statement.setInt(1, user.id);
                statement.setInt(2, user.online);
                //statement.setInt(3, user.time);
                statement.setLong(3,unixTime);
                statement.executeUpdate();
            }
            connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    List<UserOnline> getAllData() {
        List<UserOnline> users = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE time;");
            while (rs.next()) {
                users.add(new UserOnline(
                        rs.getInt("id"),
                        rs.getInt("online"),
                        rs.getInt("time")
                ));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    List<UsersOnline> getUsersOnline(int timeStart, int timeEnd) {
        List<UsersOnline> users = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
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
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}