package group907.baybikov.springwitch.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductForm {

    @Size(min = 5, max = 20, message = "Название короткое или слишком длинное")
    private String name;
    @NotBlank(message = "Описание не может быть пустым")
    private String description;
    @Positive(message = "Цена не может быть отрицательной")
    private Double price;
    private MultipartFile image;

    private Long categoryId;
}
