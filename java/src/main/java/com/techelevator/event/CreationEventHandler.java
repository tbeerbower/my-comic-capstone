package com.techelevator.event;

import com.techelevator.model.Comic;
import com.techelevator.model.User;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.math.BigDecimal;


@Service
public class CreationEventHandler {
    private static final BigDecimal STARTING_BALANCE = new BigDecimal("1000.00");

    private final Validator validator;

    public CreationEventHandler(Validator validator) {
        this.validator = validator;
    }

    @EventListener
    @Transactional(value = Transactional.TxType.MANDATORY)
    public void handleComicCreationEvent(Comic.CreationEvent event) {

    }

    @EventListener
    @Transactional(value = Transactional.TxType.MANDATORY)
    public void handleUserCreationEvent(User.CreationEvent event) {
        User user = event.getUser();
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    }
}
