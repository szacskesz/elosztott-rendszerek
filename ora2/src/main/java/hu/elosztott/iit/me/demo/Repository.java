package hu.elosztott.iit.me.demo;

import java.util.List;

public interface Repository {
    List<String> searchByText(String queryString);
}
