package springapp.web;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springapp.model.Group;
import springapp.model.Person;

@Service
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	Person person = (Person) target;

    	/*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
                "person.firstName", "Field First Name is required.");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
                "person.lastName", "Field lastName is required.");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail",
                "person.mail", "Field mail is required.");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "web",
                "person.web", "Field web is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "groupId",
                "person.groupId", "Field groupId is required.");
		*/
    }

}