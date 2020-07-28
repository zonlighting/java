package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query(value = "SELECT p FROM product_demo p")
    List<ProductEntity> findAllQuery();

    @Modifying
    @Query(value = "insert into product_demo (name, description) values (:name, :description)", nativeQuery = true)
    void saveQuery(@Param("name") String name, @Param("description") String description);

    @Modifying
    @Query("delete product_demo p where p.id = :id")
    void deleteQuery(@Param("id") Long id);

    @Modifying
    @Query("update product_demo p set p.name =  :name, p.description = :description  where p.id = :id")
    void updateQuery(@Param("id") Long id, @Param("name") String name, @Param("description") String description);

    @Query(value = "SELECT p FROM product_demo p WHERE p.name LIKE %:name%")
    List<ProductEntity> searchName(@Param("name") String name);

    @Query(value = "SELECT * FROM product_demo p WHERE Match(p.name) Against(:name)",nativeQuery = true)
    List<ProductEntity> search(@Param("name") String name);

    @Query(value = "SELECT * FROM product_demo p Limit :page,:size", nativeQuery = true)
    List<ProductEntity> list(@Param("page") Integer page, @Param("size") Integer size);


}

