package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumber, Long> {

	@Override
	public void initialize(PrimeNumber constraintAnnotation) {
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Double val = value.doubleValue();
		for (int i = 2; i <= Math.ceil(val / 2); i++) {
			if (val % i == 0) return false;
		}
		return true;
	}

}
