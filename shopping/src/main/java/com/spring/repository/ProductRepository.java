package com.spring.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.constants.ProductMetaModel;
import com.spring.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

	Product findByProductid(int productid);

	void deleteByProductid(int productid);

	List<Product> findAllBySize(String string);

	List<Product> findAll(Specification<Product> spec);

 
	static Specification<Product> nameLike(String productname) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(ProductMetaModel.PRODUCT_NAME),
				"%" + productname + "%");
	}

	static Specification<Product> categoryLike(String categoria) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(ProductMetaModel.CATEGORIA),
				"%" + categoria + "%");
	}

	static Specification<Product> sizeLike(String size) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(ProductMetaModel.SIZE),
				"%" + size + "%");
	}
	static Specification<Product> sexLike(String sex) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(ProductMetaModel.SEX),
				"%" + sex + "%");
	}

	public static Specification<Product> getProductByCategoryAndSizeAndSex(String categoria, String size, String sex) {
		return Specification.where(categoryLike(categoria)).and(sizeLike(size).and(sexLike(sex))); 
	}
}
