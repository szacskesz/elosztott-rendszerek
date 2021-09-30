package hu.elosztott.iit.me.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final Calculator calculator;
    private final Repository repository;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String main() {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double calculate(@Valid CalculatorRequestDTO requestDTO) {
        return this.calculator.add(requestDTO.getOperand1(), requestDTO.getOperand2());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/repository", produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> repoSearch(@Valid RepositoryRequestDto requestDTO) {
        return this.repository.searchByText(requestDTO.getQueryString());
    }
}
