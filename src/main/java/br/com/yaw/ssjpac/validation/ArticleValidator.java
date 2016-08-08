package br.com.yaw.ssjpac.validation;

import static javax.validation.Validation.buildDefaultValidatorFactory;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Component;

import diligentia.model.Article;


@Component
public class ArticleValidator implements Validator<Article> {
	
	private static ValidatorFactory factory;
	
	static {
		factory = buildDefaultValidatorFactory();
	}

	public String validate(Article m) {
		StringBuilder sb = new StringBuilder();
		if (m != null) {
			javax.validation.Validator validator = factory.getValidator();
			Set<ConstraintViolation<Article>> constraintViolations = validator.validate(m);
			
			if (!constraintViolations.isEmpty()) {
				sb.append("Validação da entidade Article\n");
				for (ConstraintViolation<Article> constraint: constraintViolations) {
					sb.append(String.format("%n%s: %s", constraint.getPropertyPath(), constraint.getMessage()));
				}
			}
		}
		return sb.toString();
	}

}
