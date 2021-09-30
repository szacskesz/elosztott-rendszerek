package hu.elosztott.iit.me.demo.github;

import lombok.Data;
import java.util.List;

@Data
public class GithubSearchResponseDto {
    private int total_count;
    private boolean incomplete_results;
    private List<GithubItemDto> items;
}
