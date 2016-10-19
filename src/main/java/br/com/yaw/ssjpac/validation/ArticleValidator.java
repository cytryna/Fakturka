package br.com.yaw.ssjpac.validation;

import static javax.validation.Validation.buildDefaultValidatorFactory;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;

import diligentia.entity.Product;
import org.springframework.stereotype.Component;


@Component
public class ArticleValidator implements Validator<Product> {
	
	private static ValidatorFactory factory;
	
	static {
		factory = buildDefaultValidatorFactory();
	}

	public String validate(Product m) {
		StringBuilder sb = new StringBuilder();
		if (m != null) {
			javax.validation.Validator validator = factory.getValidator();
			Set<ConstraintViolation<Product>> constraintViolations = validator.validate(m);
			
			if (!constraintViolations.isEmpty()) {
				sb.append("Validação da entidade Product\n");
				for (ConstraintViolation<Product> constraint: constraintViolations) {
					sb.append(String.format("%n%s: %s", constraint.getPropertyPath(), constraint.getMessage()));
				}
			}
		}
		return sb.toString();
	}

}
