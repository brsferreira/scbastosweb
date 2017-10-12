package com.scbastos.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "(^[a-zA-ZáéíóúàâêôãõüçÁÉÍÓÚÀÂÊÔÃÕÜÑÇ'\\s]*$)?") // TESTAR: (^[a-zA-Z\u00C0-\u00FF\\s]*$)?
public @interface Nome {
	
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "O nome deve conter apenas letras e espaços";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
