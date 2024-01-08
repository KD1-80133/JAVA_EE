package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddProductDTO;
import com.app.dto.ProductDTO;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/category/{categoryId}")
	public AddProductDTO addProductToCategory(@RequestBody @Valid AddProductDTO dto) {
		return productService.addNewProductInCategory(dto);
	}

	@GetMapping("/category/{categoryId}")
	public List<AddProductDTO> getProductsByCategory(@PathVariable Long categoryId) {
		return productService.getProductsByCategory(categoryId);
	}

	@PutMapping("/{productId}")
	public ProductDTO updateProductPrice(@PathVariable Long productId, @RequestParam double newPrice) {
		return productService.updateProductPrice(productId, newPrice);
	}
	@DeleteMapping("/{productId}")
	public String deleteByProductId(@PathVariable Long productId)
	{
		return productService.deletebyProductId(productId);
	}
}
