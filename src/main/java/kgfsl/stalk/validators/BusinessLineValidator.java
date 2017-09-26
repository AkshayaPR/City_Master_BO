package kgfsl.stalk.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import kgfsl.stalk.repository.BusinessLineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessLineValidator implements ConstraintValidator<BusinessLine, String> {

	@Autowired
	private BusinessLineRepository repository;

	@Override
	public void initialize(BusinessLine constraintAnnotation) {	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
		boolean isValid = false;
		long count = repository.countByCode(value);
		isValid = count == 0 ? false : true;
		if (!isValid) {
			constraintContext.disableDefaultConstraintViolation();
			constraintContext.buildConstraintViolationWithTemplate("No such Business Line exists with given code: " + value)
					.addConstraintViolation();
		}
		return isValid;
	}

}
