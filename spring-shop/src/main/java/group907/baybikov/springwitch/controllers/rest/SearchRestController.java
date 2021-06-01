package group907.baybikov.springwitch.controllers.rest;

import group907.baybikov.springwitch.dto.ProductDto;
import group907.baybikov.springwitch.forms.SearchRequest;
import group907.baybikov.springwitch.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchRestController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Поиск услуг по названию с сортировкой")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = ProductDto.class)})
    @PostMapping("/search")
    public List<ProductDto> search(@RequestBody SearchRequest searchRequest) {
        System.out.println(searchRequest);
        return productService.getProductsBySearchRequest(searchRequest);
    }

    @ApiOperation(value = "Возвращает список названий услуг")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = ProductDto.class)})
    @GetMapping("/service")
    public List<String> products() {
        return productService.allProducts()
                .stream().map(ProductDto::getName)
                .collect(Collectors.toList());
    }
}
