package com.vti.service;

import com.vti.dto.ProductDto;
import com.vti.form.ProductCreateForm;
import com.vti.model.Product;

import java.util.List;

public interface IProductService {
    Product insert(ProductCreateForm form);

    List<ProductDto> findAll();

    List<ProductDto> findAllByCategory(String category);

    List<ProductDto> findAllByBrand(String brand);


    ProductDto findById(Integer id);



}
