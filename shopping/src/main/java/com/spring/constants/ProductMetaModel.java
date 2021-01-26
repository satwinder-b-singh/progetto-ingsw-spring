package com.spring.constants;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.spring.model.Product;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class ProductMetaModel  {
	public static volatile SingularAttribute<Product, Integer> productid;
	  public static volatile SingularAttribute<Product, String> description;
	  public static volatile SingularAttribute<Product, String> productname;
	  public static volatile SingularAttribute<Product, Integer> price;

	  public static volatile SingularAttribute<Product, Integer> quantity;
	  public static volatile SingularAttribute<Product, String> categoria;
	  public static volatile SingularAttribute<Product, String> size;
	  public static volatile SingularAttribute<Product, String> sex;

	  public static final String DESCRIPTION = "description";
	  public static final String PRODUCT_NAME = "productname";
	  public static final String PRODUCT_ID = "productid";
	  public static final String PRICE = "price";

	  public static final String CATEGORIA = "categoria";

	  public static final String SIZE = "size";
	  public static final String SEX = "sex";
	  public static final String QUANTITY = "quantity";

}
