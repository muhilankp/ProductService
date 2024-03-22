package com.example.productservice.services;

import com.example.productservice.dtos.FakeProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeProductService implements IProductService{
    RestTemplate restTemplate;

    public FakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeProductDto fakeProductDto = this.restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeProductDto.class);

        if (fakeProductDto == null) {return null;}

        return convertProductDtoToProduct(fakeProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        FakeProductDto[] fakeProductDtos = this.restTemplate.getForObject("https://fakestoreapi.com/products/", FakeProductDto[].class);

        if (fakeProductDtos == null) {return allProducts;}

        for (FakeProductDto productDto: fakeProductDtos) {
            Product product = convertProductDtoToProduct(productDto);
            allProducts.add(product);
        }

        return allProducts;
    }

    @Override
    public Product updateProduct(Long id) {
        return null;
    }

    private Product convertProductDtoToProduct(FakeProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());

        Category category = new Category();
        category.setTitle(productDto.getCategory());

        product.setCategory(category);

        return product;
    }
}
