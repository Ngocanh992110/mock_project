package com.vti.repository;

import com.vti.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByCategory (String category);

    List<Product> findAllByBrand (String brand);

}
