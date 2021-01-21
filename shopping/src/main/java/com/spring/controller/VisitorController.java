/**
 * 
 */
package com.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.constants.ProductMetaModel;
import com.spring.constants.ResponseCode;
import com.spring.model.Product;
import com.spring.repository.ProductRepository;
import com.spring.response.prodResp;

/**
 * @author satwinder.b.singh version : 1.0
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/visitor")
public class VisitorController {
	List<Product> products;
	@Autowired
	private ProductRepository prodRepo;

	@PostMapping("/getProductsVisitor") // Funziona , ma non carica l'img
	public ResponseEntity<prodResp> getProductsForVisitor() throws IOException {

		prodResp resp = new prodResp();

		try {
			resp.setStatus(ResponseCode.SUCCESS_CODE);
			resp.setMessage(ResponseCode.LIST_SUCCESS_MESSAGE);

			resp.setOblist(prodRepo.findAll());
		} catch (Exception e) {
			resp.setStatus(ResponseCode.FAILURE_CODE);
			resp.setMessage(e.getMessage());

		}

		return new ResponseEntity<prodResp>(resp, HttpStatus.ACCEPTED);
	}

//	@RequestMapping
//	public ResponseEntity<prodResp> findbyCategory(@RequestParam)

	@RequestMapping("/findBySizeAndCategoryAndSex")
	public ResponseEntity<prodResp> findByProductName(
			@RequestParam(name = ProductMetaModel.SIZE, defaultValue = "") String size,
			@RequestParam(name = ProductMetaModel.CATEGORIA, defaultValue = "") String categoria,
			@RequestParam(name = ProductMetaModel.SEX, defaultValue = "") String sex) throws IOException {
		System.out.println("ciaoooo");
		
		prodResp resp = new prodResp();
		try {
           if (size.equals("") && sex.equals("") && categoria.equals(""))
           {
        	   resp.setOblist(prodRepo.findAll());
           }
           else
           {
        	   if(!size.equals("") && !categoria.equals("") && !sex.equals(""))
        		   products = prodRepo
					.findAll(ProductRepository.getProductBySizeAndCategoryAndSex(size,categoria , sex )) ;
        	   if(size.equals("") && !categoria.equals("") && !sex.equals("") )  
        		   products = prodRepo
					.findAll(ProductRepository.getProductByCategoryAndSex(categoria , sex )) ;//Categoria e sex

        	   if  (size.equals("") && categoria.equals("") && !sex.equals("")) //SEX   
            	  products = prodRepo.findAll(ProductRepository.sexLike(sex));
              
               if(size.equals("") && !categoria.equals("") &&  sex.equals("")) //CATEGORIA
            	   products = prodRepo.findAll(ProductRepository.categoryLike(categoria));
               
               if(!size.equals("") &&  categoria.equals("") &&  sex.equals("")) //SIZE
            	   products = prodRepo.findAll(ProductRepository.sizeLike(size));
               if(!size.equals("") &&  categoria.equals("") &&  !sex.equals("")) //SIZE && SEX
            	   products = prodRepo.findAll(ProductRepository.getProductBySizeAndSex(size , sex));
               if(!size.equals("") &&  !categoria.equals("") &&  sex.equals("")) //SIZE && CATEGORIA
            	   products = prodRepo.findAll(ProductRepository.getProductBySizeAndSex(size , sex));
               

   			resp.setStatus(ResponseCode.SUCCESS_CODE);
   			resp.setMessage(ResponseCode.LIST_SUCCESS_MESSAGE);
   			   
   			
           }
           System.out.println("ciaoo2222" + products);
  			resp.setOblist(products);
  			
		} catch (Exception e) {
			resp.setStatus(ResponseCode.FAILURE_CODE);
			resp.setMessage(e.getMessage());

		}

		return new ResponseEntity<prodResp>(resp, HttpStatus.ACCEPTED);

	}

}
