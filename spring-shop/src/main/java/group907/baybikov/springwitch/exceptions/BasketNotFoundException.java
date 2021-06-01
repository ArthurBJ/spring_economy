package group907.baybikov.springwitch.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BasketNotFoundException extends Exception {

    public BasketNotFoundException(String basket_not_found) {
        super(basket_not_found);
    }
}
