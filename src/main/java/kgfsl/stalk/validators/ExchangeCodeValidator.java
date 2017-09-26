package kgfsl.stalk.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kgfsl.stalk.repository.ExchangeRepository;

@Service
public class ExchangeCodeValidator implements ConstraintValidator<ExchangeCode, String> {

	@Autowired
	private ExchangeRepository repository;

	@Override
	public void initialize(ExchangeCode constraintAnnotation) {	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
		boolean isValid = false;
		long count = repository.countByCode(value);
		isValid = count == 0 ? false : true;
		if (!isValid) {
			constraintContext.disableDefaultConstraintViolation();
			constraintContext.buildConstraintViolationWithTemplate("No such Exchange exists with given code: " + value)
					.addConstraintViolation();
		}
		return isValid;
	}

}
