package com.example.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    public long id;
    public String title;
    public double price;
    public Category category;
    public String description;
    public String image;
}
