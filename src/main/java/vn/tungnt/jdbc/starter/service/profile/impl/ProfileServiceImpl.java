package vn.tungnt.jdbc.starter.service.profile.impl;

import org.postgresql.core.SqlCommand;
import vn.tungnt.jdbc.starter.config.DatasourceConfiguration;
import vn.tungnt.jdbc.starter.config.OtherDatasource;
import vn.tungnt.jdbc.starter.repository.profile.ProfileRepository;
import vn.tungnt.jdbc.starter.repository.profile.impl.ProfileRepositoryImpl;
import vn.tungnt.jdbc.starter.service.profile.ProfileService;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl() {
        this.profileRepository = new ProfileRepositoryImpl();
    }

    public List<String> getAllProfileNames() {
        final String query = "SELECT display_name FROM user_profile_profile";
        final ResultSet resultSet = this.profileRepository.allProfiles(query);
        try {
            if (Objects.isNull(resultSet)) {
                return Collections.emptyList();
            } else {
                List<String> results = new ArrayList<>();
                while (resultSet.next()) {
                    results.add(resultSet.getString("display_name"));
                }
                return results;
            }
        } catch (SQLException sqlE) {

        }

        return Collections.emptyList();
    }
}
