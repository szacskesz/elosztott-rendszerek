package hu.elosztott.iit.me.demo;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class CalculatorRequestDTO {

    @NotNull
    private Double operand1;

    @NonNull
    private Double operand2;

    @NotNull
    private String operator;
}
