package com.example.crud_app.validator;

import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ValidationErrorResponse {
    private List<ConstraintViolation> violations;

    public ValidationErrorResponse(List<Violation> violations) {
    }
}
