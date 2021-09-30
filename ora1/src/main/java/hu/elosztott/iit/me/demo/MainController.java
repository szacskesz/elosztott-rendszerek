package hu.elosztott.iit.me.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final Calculator calculator;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String main() {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double calculate(@Valid CalculatorRequestDTO requestDTO) {
        return this.calculator.add(requestDTO.getOperand1(), requestDTO.getOperand2());
    }
}
