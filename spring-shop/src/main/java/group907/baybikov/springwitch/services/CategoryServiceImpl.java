package group907.baybikov.springwitch.services;

import group907.baybikov.springwitch.dto.CategoryDto;
import group907.baybikov.springwitch.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream().map(c -> modelMapper.map(c, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
