package kgfsl.stalk.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kgfsl.stalk.repository.SegmentRepository;

@Service
public class SegmentCodeValidator implements ConstraintValidator<SegmentCode, String> {

	@Autowired
	private SegmentRepository repository;

	@Override
	public void initialize(SegmentCode constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
		boolean isValid = false;
		long count = repository.countByCode(value);
		isValid = count == 0 ? false : true;
		if (!isValid) {
			constraintContext.disableDefaultConstraintViolation();
			constraintContext.buildConstraintViolationWithTemplate("No such Segment exists with given code: " + value)
					.addConstraintViolation();
		}
		return isValid;
	}

}
