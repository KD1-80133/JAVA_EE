package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddProductDTO {
     @NotNull
	@JsonProperty(value = "cat_id",access = Access.WRITE_ONLY)
	private Long catid;
	@NotNull(message ="Product name required!!!!")
	private String name;
	private String description;
	@Max(value = 500,message = "price must be < 500")
	private double price;
	private int availableStock;
	@Future
	private LocalDate expiryDate;
}
