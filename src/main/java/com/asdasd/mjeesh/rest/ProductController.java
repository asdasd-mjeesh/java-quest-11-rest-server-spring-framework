package com.asdasd.mjeesh.rest;

import com.asdasd.mjeesh.dto.ProductDto;
import com.asdasd.mjeesh.dto.mapper.ProductMapper;
import com.asdasd.mjeesh.exception_heandling.product.NoSuchProductException;
import com.asdasd.mjeesh.model.Product;
import com.asdasd.mjeesh.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping("/")
    public ProductDto addNewProduct(@RequestBody Product product) {
        return productMapper.map(productService.save(product));
    }

    @GetMapping("/")
    public List<ProductDto> findAllProducts() {
        return productMapper.map(productService.findAll());
    }

    @GetMapping("/producer-id/{id}")
    public List<ProductDto> findAllProductsByProducerId(@PathVariable Long id) {
        return productMapper.map(productService.findAllByProducerId(id));
    }

    @GetMapping("/producer-name/{producerName}")
    public List<ProductDto> findAllProductsByProducerName(@PathVariable String producerName) {
        return productMapper.map(productService.findAllByProducerName(producerName));
    }

    @PutMapping("/")
    public ProductDto updateProduct(@RequestBody Product product) {
        return productMapper.map(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        if (!productService.delete(id)) {
            throw new NoSuchProductException("Database is not exist product with id = " + id);
        }
        return "product with id = " + id + " was deleted";
    }
}
