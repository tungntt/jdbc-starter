package vn.tungnt.jdbc.starter.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public final class DatasourceConfiguration {

    private static final String USER_NAME = "postgres";
    private static final String PASS_WORD = "example";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ceb";
    private static DatasourceConfiguration INSTANCE;

    static {
        try {
            INSTANCE = new DatasourceConfiguration();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private final Connection connection;

    private DatasourceConfiguration() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL, USER_NAME, PASS_WORD);
    }

    public static DatasourceConfiguration getDatasource() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet executeQuery(final String query) throws SQLException {
        return this.connection.createStatement().executeQuery(query);
    }
}
