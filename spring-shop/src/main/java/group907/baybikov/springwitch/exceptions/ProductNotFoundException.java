package group907.baybikov.springwitch.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String product_not_found) {
        super(product_not_found);
    }
}
