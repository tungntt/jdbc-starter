package vn.tungnt.jdbc.starter.repository.profile;

import java.sql.ResultSet;

public interface ProfileRepository {

    ResultSet allProfiles(final String sql);
}
