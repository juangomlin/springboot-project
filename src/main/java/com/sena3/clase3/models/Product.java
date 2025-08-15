package com.sena3.clase3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "productos")

public class Product {
    @Id
    @Column (name = "id_producto")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_product;
    private String category;
    private String name;
    private Integer price;
}
