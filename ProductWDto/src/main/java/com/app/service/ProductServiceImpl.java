package com.app.service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CategoryDao;
import com.app.dao.ProductDao;
import com.app.dto.AddProductDTO;
import com.app.dto.ProductDTO;
import com.app.entities.Category;
import com.app.entities.Products;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddProductDTO addNewProductInCategory(AddProductDTO dto) {
        Category category = categoryDao.findById(dto.getCatid())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Products productEntity = modelMapper.map(dto, Products.class);
        productEntity.setProductCategory(category);
        Products savedProduct = productDao.save(productEntity);
        return modelMapper.map(savedProduct, AddProductDTO.class);
    }
    @Override
    public List<AddProductDTO> getProductsByCategory(Long categoryId) {
        Category category = categoryDao.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        List<Products> productsByCategory = productDao.findByProductCategory(category);
        return productsByCategory.stream()
                .map(product -> modelMapper.map(product, AddProductDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public ProductDTO updateProductPrice(Long productId, double newPrice) {
        Products product = productDao.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setPrice(newPrice);
        Products updatedProduct = productDao.save(product);
        return modelMapper.map(updatedProduct, ProductDTO.class);
    }
	@Override
	public String deletebyProductId(Long productId) {
		if(productDao.existsById(productId))
		{
			productDao.deleteById(productId);
			return "deleted product";
		}
		return "invalid id";
	}
	
    
	
}
