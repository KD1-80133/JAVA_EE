package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="category")
@Getter
@Setter
@ToString(callSuper =true)
public class Category extends BaseEntity{
	@Column(unique=true,length=20)
	private String name;
	@Column(length=200)
	private String description;
	
}
