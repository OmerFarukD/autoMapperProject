package com.example.automapperproject.Repository;

import com.example.automapperproject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    // id si belli aralıktaki ürünşleri getirsin


    // JPQL
    @Query("from Product where id<= :max and id>= :min")
    List<Product> getAllByIdRange(@Param("min") Integer min,@Param("max") Integer max);
}
