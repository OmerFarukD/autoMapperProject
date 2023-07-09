package com.example.automapperproject.Controller;

import com.example.automapperproject.Dto.ProductAddDto;
import com.example.automapperproject.Dto.ProductResponseDto;
import com.example.automapperproject.Entity.Product;
import com.example.automapperproject.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
@RequiredArgsConstructor

public class ProductController {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @PostMapping("add")
    public void add(@RequestBody ProductAddDto productAddDto){
        Product product = this.modelMapper.map(productAddDto, Product.class);
        product.setId(null);
        this.productRepository.save(product);
    }

    @GetMapping("getall")
    public List<ProductResponseDto> getAll(){
       List<Product> products =this.productRepository.findAll();
       // todo : 1 . yöntem foreach döngüsü ile

/*        List<ProductResponseDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDto dto = this.modelMapper.map(product,ProductResponseDto.class);
            dtoList.add(dto);

        }
        return  dtoList;*/
          // predicate
        return products
                .stream()
                .map(x->this.modelMapper.map(x,ProductResponseDto.class))
                .toList();
    }

    @GetMapping("/getallbyrange")
    public List<ProductResponseDto> getAllByRange(@RequestParam Integer min, @RequestParam Integer max){
        List<Product> products = this.productRepository.getAllByIdRange(min,max);
        return products.stream().map(x->this.modelMapper.map(x,ProductResponseDto.class)).toList();
    }

    @GetMapping("/getallbyrange1")
    public List<ProductResponseDto> getAllByRange1(@RequestParam Integer min, @RequestParam Integer max){
        List<Product> products =this.productRepository.findAll();
        return products.stream().map(x->this.modelMapper.map(x,ProductResponseDto.class))
                .filter(x-> x.getId()>=min && x.getId()<=max).toList();
    }

}
