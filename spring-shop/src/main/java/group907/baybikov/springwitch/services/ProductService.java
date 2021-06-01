package group907.baybikov.springwitch.services;

import group907.baybikov.springwitch.dto.ProductDto;
import group907.baybikov.springwitch.forms.ProductForm;
import group907.baybikov.springwitch.forms.SearchRequest;
import group907.baybikov.springwitch.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<ProductDto> allProducts();

    List<ProductDto> getProductsBySearchRequest(SearchRequest searchRequest);

    Optional<ProductDto> getProductById(long id);

    void save(ProductForm productForm);
}
