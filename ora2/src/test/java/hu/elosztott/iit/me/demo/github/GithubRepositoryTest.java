package hu.elosztott.iit.me.demo.github;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import hu.elosztott.iit.me.demo.RestCommunicationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class GithubRepositoryTest {
    private final String apiUrl = "https://api.github.com/search/repositories";

    @Test
    void searchByTextPass() {
        //GIVEN
        RestTemplate mockRestTemplate = mock(RestTemplate.class);
        GithubRepository repository = new GithubRepository(mockRestTemplate);
        String qs = "valami";

        GithubItemDto item = new GithubItemDto();
        item.setName("demo");

        List<GithubItemDto> items = new ArrayList<>();
        items.add(item);

        GithubSearchResponseDto responseDto = new GithubSearchResponseDto();
        responseDto.setItems(items);

        //WHEN
        when(mockRestTemplate.getForEntity(apiUrl + "?q=" + qs, GithubSearchResponseDto.class)).thenReturn(
            new ResponseEntity<>(responseDto, HttpStatus.OK)
        );

        //THEN
        List<String> response = repository.searchByText(qs);

        assertThat(response, hasSize(1));
        assertThat(response.get(0), is("demo"));

        verify(mockRestTemplate).getForEntity(apiUrl + "?q=" + qs, GithubSearchResponseDto.class);
    }

    @Test
    void searchByTextFail404() {
        //GIVEN
        RestTemplate mockRestTemplate = mock(RestTemplate.class);
        GithubRepository repository = new GithubRepository(mockRestTemplate);
        String qs = "valami2";

        //WHEN
        when(mockRestTemplate.getForEntity(apiUrl + "?q=" +  qs, GithubSearchResponseDto.class)).thenReturn(
            new ResponseEntity<>(null, HttpStatus.NOT_FOUND)
        );


        //THEN
        try {
            repository.searchByText(qs);
            fail("Exception not thrown");
        } catch(RestCommunicationException ex) {
            //Exception thrown
        }

        verify(mockRestTemplate).getForEntity(apiUrl + "?q=" + qs, GithubSearchResponseDto.class);
    }
}