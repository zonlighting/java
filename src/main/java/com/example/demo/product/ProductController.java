package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping("/api/v1/products")
    public ResponseEntity<List<ProductEntity>> findAll() {
        return ResponseEntity.ok(productServices.findAll());
    }

    @GetMapping("/api/v1/products-query")
    public ResponseEntity<List<ProductEntity>> findAllQuery() {
        return ResponseEntity.ok(productServices.findAllQuery());
    }
    @PostMapping("/api/v1/add")
    public ResponseEntity<String> save(@RequestBody ProductEntity entity){
        productServices.save(entity);
        return ResponseEntity.ok("Created!");
    }
    @PostMapping("/api/v1/add-query")
    public ResponseEntity<String> saveQuery(@RequestBody ProductEntity entity){
        productServices.saveQuery(entity);
        return ResponseEntity.ok("Created!");
    }
    @DeleteMapping("/api/delete/{id}")
    public  ResponseEntity<String> delete(@PathVariable Long id){
        productServices.delete(id);
        return ResponseEntity.ok("Delete!");
    }
    @DeleteMapping("/api/delete-query/{id}")
    public  ResponseEntity<String> deleteQuery(@PathVariable Long id){
        productServices.deleteQuery(id);
        return ResponseEntity.ok("Delete!");
    }
    @PutMapping("/api/put/{id}")
    public  ResponseEntity<String> put(@PathVariable Long id,@RequestBody ProductEntity entity){
        productServices.put(id,entity);
        return ResponseEntity.ok("Put!");
    }
    @PutMapping("/api/put-query/{id}")
    public  ResponseEntity<String> putQuery(@PathVariable Long id,@RequestBody ProductEntity entity){
        productServices.putQuery(id,entity);
        return ResponseEntity.ok("Put!");
    }
    @GetMapping("/api/v1/product/")
    public ResponseEntity<Optional<ProductEntity>> findId(@RequestParam Long id){
        return ResponseEntity.ok(productServices.findId(id));
    }
    @GetMapping("/api/v1/product-search/")
    public ResponseEntity<List<ProductEntity>> searchName(@RequestParam String name){
        return ResponseEntity.ok(productServices.searchName(name));
    }
    @GetMapping("/api/v1/search/")
    public ResponseEntity<List<ProductEntity>> search(@RequestParam String name){
        return ResponseEntity.ok(productServices.search(name));
    }
    @GetMapping("/api/v1/product-list/")
    public ResponseEntity<List<ProductEntity>> list(@RequestParam Integer page,@RequestParam Integer size){
        return ResponseEntity.ok(productServices.list(page,size));
    }
}
