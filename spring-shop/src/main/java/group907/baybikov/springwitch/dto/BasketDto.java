package group907.baybikov.springwitch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketDto {

    private Long id;
    private List<ProductDto> products;
    private UserDto user;
}
