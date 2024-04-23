package demo.multipledb.services;

import demo.multipledb.dtos.ProductResponseDto;

public interface ProductService {
    ProductResponseDto getProduct(Long productId);
}
