package com.vinsguru.productservice.util;

import com.vinsguru.productservice.dto.ProductDto;
import com.vinsguru.productservice.entity.Product;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class EntityDtoUtil {

    public Product toEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        return product;
    }

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);

        return productDto;
    }

}
