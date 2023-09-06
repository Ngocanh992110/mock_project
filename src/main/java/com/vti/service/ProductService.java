package com.vti.service;

import com.vti.dto.ProductDto;
import com.vti.form.ProductCreateForm;
import com.vti.model.Product;
import com.vti.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Configurable
public class ProductService implements IProductService {

    @Autowired
    IProductRepository repository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Product insert(ProductCreateForm form) {
        Product product = mapper.map(form, Product.class);
        return repository.save(product);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList = repository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            ProductDto productDto = mapper.map(product, ProductDto.class);
            productDtoList.add(productDto);
        }
        return  productDtoList;
    }

    @Override
    public List<ProductDto> findAllByCategory(String category) {
        List<Product> productList = repository.findAllByCategory(category);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            ProductDto productDto = mapper.map(product, ProductDto.class);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> findAllByBrand(String brand) {
        List<Product> productList = repository.findAllByBrand(brand);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            ProductDto productDto = mapper.map(product, ProductDto.class);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    @Override
    public ProductDto findById(Integer id) {
        Product product = repository.findById(id).orElse(null);
        return mapper.map(product, ProductDto.class);
    }
}
