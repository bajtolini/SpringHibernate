package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidator implements ConstraintValidator<StartWith, String> {

	private String begin;
	private String end;
	
	@Override
	public void initialize(StartWith constraintAnnotation) {
		begin = constraintAnnotation.begin().toUpperCase();
		end = constraintAnnotation.end().toLowerCase();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value.startsWith(begin) && value.endsWith(end);
	}

}
