package com.asdasd.mjeesh.rest;

import com.asdasd.mjeesh.model.dto.ProductDto;
import com.asdasd.mjeesh.model.dto.ProductFilter;
import com.asdasd.mjeesh.model.dto.mapper.ProductMapper;
import com.asdasd.mjeesh.exception_heandling.product.NoSuchProductException;
import com.asdasd.mjeesh.model.Product;
import com.asdasd.mjeesh.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

    @GetMapping("/{pageNo}")
    public List<ProductDto> findAllProducts(@PathVariable Integer pageNo) {
        return productMapper.map(productService.findAll(pageNo));
    }

    @GetMapping("/id/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        var executeResult = productService.findById(id);
        if (Objects.isNull(executeResult)) {
            throw new NoSuchProductException("No such product with id = " + id);
        }

        return productMapper.map(executeResult);
    }

    @GetMapping("/producer-id/{id}/{pageNo}")
    public List<ProductDto> findAllProductsByProducerId(@PathVariable Long id,
                                                        @PathVariable Integer pageNo) {
        return productMapper.map(productService.findAllByProducerId(id, pageNo));
    }

    @GetMapping("/producer-name/{producerName}/{pageNo}")
    public List<ProductDto> findAllProductsByProducerName(@PathVariable String producerName,
                                                          @PathVariable Integer pageNo) {
        return productMapper.map(productService.findAllByProducerName(producerName, pageNo));
    }

    @PostMapping("/filter/{pageNo}")
    public List<ProductDto> findAllProductsByFilter(@RequestBody ProductFilter productFilter,
                                                    @PathVariable("pageNo") Integer pageNo) {
        return productMapper.map(productService.findByFilter(productFilter, pageNo));
    }

//    @GetMapping("/filter/{title}/{producerName}/{minCost}/{maxCost}/{pageNo}")
//    public List<ProductDto> findAllProductsByFilter(@PathVariable(value = "") String title,
//                                                    @PathVariable(value = "") String producerName,
//                                                    @PathVariable(value = "0") BigDecimal minCost,
//                                                    @PathVariable(value = "999999") BigDecimal maxCost,
//                                                    @PathVariable(value = "0") Integer pageNo) {
//
//        System.out.println("title = " + title);
//        return productMapper.map(productService.findByFilter(title, producerName, minCost, maxCost, pageNo));
//    }

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
