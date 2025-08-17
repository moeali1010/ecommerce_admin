package com.ecommerce.admin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ec_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    @Column(name = "cat_id")
    private Long id;

    @Column(name = "cat_name")
    private String catName;

    public Category(String name){
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return catName;
    }

    public void setName(String name) {
        this.catName = name;
    }

}
