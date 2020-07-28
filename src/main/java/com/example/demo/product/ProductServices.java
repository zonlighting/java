package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    
    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public List<ProductEntity> findAllQuery() {
        return productRepository.findAllQuery();
    }

    public void save(ProductEntity entity){
        productRepository.save(entity);
    }
    public void saveQuery(ProductEntity entity){
        productRepository.saveQuery(entity.getName(),entity.getDescription());
    }
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteQuery(Long id) {
        productRepository.deleteQuery(id);
    }

    public void put(Long id, ProductEntity entity) {
        entity.setId(id);
        productRepository.save(entity);
    }

    public void putQuery(Long id, ProductEntity entity) {
        productRepository.updateQuery(id,entity.getName(),entity.getDescription());
    }

    public Optional<ProductEntity> findId(Long id) {
        return productRepository.findById(id);
    }

    public List<ProductEntity> searchName(String name) {
       return productRepository.searchName(name);
    }
    public List<ProductEntity> search(String name) {
        return productRepository.search(name);
    }

    public List<ProductEntity> list(Integer page,Integer size) {
        if(page==0){
            return productRepository.list(0,size);
        }
        else {
            return productRepository.list((page-1)*size,size);
        }


    }


}