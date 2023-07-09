package com.example.automapperproject.Controller;

import com.example.automapperproject.Dto.CategoryAddDto;
import com.example.automapperproject.Entity.Category;
import com.example.automapperproject.Entity.Product;
import com.example.automapperproject.Repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;



    @PostMapping("/add")
    public void add(@RequestBody CategoryAddDto categoryAddDto){
        Category category = this.modelMapper.map(categoryAddDto,Category.class);
        category.setCategoryId(null);

        this.categoryRepository.save(category);
    }

    @GetMapping("/getall")
    public List<Category> getAll(){
        return this.categoryRepository.findAll();
    }

}
