package com.example.automapperproject.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "products")
@Entity
@Getter
@Setter
public class Product {
//categoryName
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column
    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
