package com.codegym.model.validator;

import com.codegym.model.Player;
import com.codegym.service.PlayerService;
import com.codegym.service.impl.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@Controller
public class PlayerValidator implements Validator {
    @Autowired
    PlayerService playerService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Player.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"identity","identity.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.empty");
    }
}
