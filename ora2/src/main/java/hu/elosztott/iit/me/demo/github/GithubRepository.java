package hu.elosztott.iit.me.demo.github;

import hu.elosztott.iit.me.demo.Repository;
import hu.elosztott.iit.me.demo.RestCommunicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GithubRepository implements Repository {

    private final String apiUrl = "https://api.github.com/search/repositories";
    private final RestTemplate restTemplate;

    @Override
    public List<String> searchByText(String queryString) {
        String url = apiUrl + "?q=" + queryString;

        ResponseEntity<GithubSearchResponseDto> response = restTemplate.getForEntity(url, GithubSearchResponseDto.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().getItems().stream().map(GithubItemDto::getName).collect(Collectors.toList());
        } else {
            throw new RestCommunicationException();
        }
    }

}