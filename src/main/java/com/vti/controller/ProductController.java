package com.vti.controller;

import com.vti.configuration.ResponseObject;
import com.vti.dto.ProductDto;
import com.vti.form.ProductCreateForm;
import com.vti.model.Product;
import com.vti.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    IProductService service;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductDto> productDtoList = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(200,"success",productDtoList)
        );
    }

    @GetMapping("/{category}")
    public ResponseEntity<?> findByCategory(@PathVariable("category") String category){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(200,"success",service.findAllByCategory(category))
        );
    }

    @GetMapping("/{brand}")
    public ResponseEntity<?> findByBrand(@PathVariable("brand") String brand){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(200,"success",service.findAllByBrand(brand))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(200,"success",service.findById(id))
        );
    }


    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody ProductCreateForm form){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(200,"success",service.insert(form))
        );
    }
}
