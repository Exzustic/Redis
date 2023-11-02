package com.springstudy.redis.controller;

import com.springstudy.redis.entity.Product;
import com.springstudy.redis.repository.ProductDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductDao dao;

    public ProductController(ProductDao dao) {
        this.dao = dao;
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return dao.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return dao.findProduct(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return dao.deleteProduct(id);
    }
}
