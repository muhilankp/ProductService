package com.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeProductDto {
    public long id;
    public String title;
    public double price;
    public String category;
    public String description;
    public String image;
}
