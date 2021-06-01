package group907.baybikov.springwitch.dto;

import group907.baybikov.springwitch.models.Basket;
import group907.baybikov.springwitch.models.Product;
import group907.baybikov.springwitch.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseDto {

    private Long id;

    private UserDto customer;
    private String date;

    private Set<ProductDto> products;
}
