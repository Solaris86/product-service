package com.vinsguru.productservice.service;

import com.vinsguru.productservice.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DataSetupService implements CommandLineRunner {

    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        final ProductDto airPodsPro = new ProductDto("AirPods Pro", 250);
        final ProductDto iPhonePro = new ProductDto("IPhone Pro 13", 1100);
        final ProductDto macBookPro = new ProductDto("MacBook Pro", 2500);

        Flux.just(airPodsPro, iPhonePro, macBookPro)
                .flatMap(productDto -> productService.insertProduct(Mono.just(productDto)))
                .subscribe(System.out::println);
    }
}
