package hu.elosztott.iit.me.demo;


import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RepositoryRequestDto {
    @NotNull
    @Size(min=3)
    private String queryString;
}
