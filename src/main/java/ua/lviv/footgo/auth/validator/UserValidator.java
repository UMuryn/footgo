package ua.lviv.footgo.auth.validator;

import ua.lviv.footgo.auth.model.User;
import ua.lviv.footgo.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
        if (user.getFirstName().length() < 2 || user.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Size.userForm.firstName");
        }
        if (user.getLastName().length() < 2 || user.getLastName().length() > 32) {
            errors.rejectValue("lastName", "Size.userForm.lastName");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
