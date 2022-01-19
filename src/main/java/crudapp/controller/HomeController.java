package crudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crudapp.dao.ProductDao;
import crudapp.model.Product;

@Controller
public class HomeController {
	@Autowired
	private ProductDao myDaoObject;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> myproductList = myDaoObject.getProducts();
		m.addAttribute("productlist", myproductList);// to make this accessible from view
		return "index";
	}

	// show addproduct form
	@RequestMapping("/add-product")
	public String addproduct(Model m) {
		m.addAttribute("title", "Add product");
		return "addproduct";
	}

	// handle add product form
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest req) {
		System.out.println(product);
		myDaoObject.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath() + "/");
		return redirectView;
	}

	// delete handler
	@RequestMapping("/delete/{productid}")
	public RedirectView deleteProduct(@PathVariable("productid") int productId, HttpServletRequest req) {
		this.myDaoObject.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath() + "/");
		return redirectView;
	}

	// update handler
	@RequestMapping("/update/{productid}")
	public String updateProduct(@PathVariable("productid") int productId, HttpServletRequest req,Model model) {
		Product product = this.myDaoObject.getProduct(productId);
		model.addAttribute("product",product);
		return "update";
	}
}