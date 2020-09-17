package vn.tungnt.jdbc.starter.service.profile.impl;

import vn.tungnt.jdbc.starter.config.DatasourceConfiguration;
import vn.tungnt.jdbc.starter.service.profile.ProfileService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProfileServiceImpl implements ProfileService {

    public List<String> getAllProfileNames() {
        final String query = "SELECT display_name FROM user_profile_profile";
        Connection connection = DatasourceConfiguration.getDatasource().getConnection();
        try(Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery(query);
            if (Objects.isNull(resultSet)) {
                return Collections.emptyList();
            } else {
                List<String> results = new ArrayList<>();
                while (resultSet.next()) {
                    results.add(resultSet.getString("display_name"));
                }
                return results;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return Collections.emptyList();
    }
}
