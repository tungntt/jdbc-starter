package vn.tungnt.jdbc.starter.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OtherDatasource {

    private static final String USER_NAME = "postgres";
    private static final String PASS_WORD = "example";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ceb";

    private final Connection connection;

    public OtherDatasource() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, USER_NAME, PASS_WORD);
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet executeQuery(final String query) throws SQLException {
        return this.connection.createStatement().executeQuery(query);
    }
}
