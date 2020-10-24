package vn.tungnt.jdbc.starter.repository.profile.impl;

import vn.tungnt.jdbc.starter.config.DatasourceConfiguration;
import vn.tungnt.jdbc.starter.repository.profile.ProfileRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfileRepositoryImpl implements ProfileRepository {

    private final Connection connection;

    public ProfileRepositoryImpl() {
        this.connection = DatasourceConfiguration.getDatasource().getConnection();
    }

    @Override
    public ResultSet allProfiles(final String sql) {
        try(Statement statement = connection.createStatement()) {
            return statement.executeQuery(sql);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}
