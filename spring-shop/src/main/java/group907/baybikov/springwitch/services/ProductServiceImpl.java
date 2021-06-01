package group907.baybikov.springwitch.services;

import group907.baybikov.springwitch.dto.ProductDto;
import group907.baybikov.springwitch.forms.ProductForm;
import group907.baybikov.springwitch.forms.SearchRequest;
import group907.baybikov.springwitch.models.Category;
import group907.baybikov.springwitch.models.Product;
import group907.baybikov.springwitch.repositories.CategoryRepository;
import group907.baybikov.springwitch.repositories.ProductRepository;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Value("${image.service.path}")
    private String serviceDir;

    @Override
    public List<ProductDto> allProducts() {
        return productRepository.findAll()
                .stream().map(p -> modelMapper.map(p, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsBySearchRequest(SearchRequest searchRequest) {
        String filter = searchRequest.getFilter();
        String input = searchRequest.getInput();

        List<Product> productList = new ArrayList<>();
        if (input != null) {
            if (filter != null) {
                if (filter.equals("cheap")) {
                    productList = productRepository.findByNameContainingOrderByPrice(input);
                } else if (filter.equals("expensive")) {
                    productList = productRepository.findByNameContainingOrderByPriceDesc(input);
                }
            } else {
                productList = productRepository.findByNameContaining(input);
            }
        } else {
            productList = productRepository.findAll();
        }

        return productList
                .stream().map(p -> modelMapper.map(p, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> getProductById(long id) {
        return productRepository.findById(id)
                .map(p -> modelMapper.map(p, ProductDto.class));
    }

    @Override
    public void save(ProductForm productForm) {
        Category category = categoryRepository.findById(productForm.getCategoryId()).get();

        Product product = Product.builder()
                .category(category)
                .description(productForm.getDescription())
                .name(productForm.getName())
                .price(productForm.getPrice())
                .image(save(productForm.getImage(), serviceDir))
                .build();

        productRepository.save(product);

    }

    @SneakyThrows
    public static String save(MultipartFile file, String directory) {
        String file_name = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        IOUtils.copyLarge(file.getInputStream(), new FileOutputStream(directory + File.separator + file_name));
        return file_name;
    }
}
