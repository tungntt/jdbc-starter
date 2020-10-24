package vn.tungnt.jdbc.starter;

import vn.tungnt.jdbc.starter.config.DatasourceConfiguration;
import vn.tungnt.jdbc.starter.service.profile.ProfileService;
import vn.tungnt.jdbc.starter.service.profile.impl.ProfileServiceImpl;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        ProfileService profileService = new ProfileServiceImpl();
        final List<String> allProfileNames = profileService.getAllProfileNames();
        allProfileNames.forEach(System.out::println);
    }
}
