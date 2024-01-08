package com.app.service;

import java.util.List;

import com.app.dto.AddProductDTO;
import com.app.dto.ProductDTO;
import com.app.entities.Products;

public interface ProductService {
	AddProductDTO addNewProductInCategory(AddProductDTO dto);
	public List<AddProductDTO> getProductsByCategory(Long categoryId);
	ProductDTO updateProductPrice(Long productId, double newPrice);
	String deletebyProductId(Long productId);
}
