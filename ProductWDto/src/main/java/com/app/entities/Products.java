package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true )
public class Products extends BaseEntity{
	@Column(unique=true,length=20)
	private String name;
	@Column(length=200)
	private String description;
	private double price ;
	@Column(name="available_stock")
	private int availableStock;
	@Column(name="expiry_date")
	private LocalDate expiryDate;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category productCategory;
}
