package com.scbastos.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import com.scbastos.validation.validator.SenhaValidacao;

@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SenhaValidacao.class})
public @interface AtributoSenha {
	
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "As senhas não conferem";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String atributo();
	
	String atributoConfirmacao();

}
