package com.shop.Controllers;

import com.shop.Entities.Order;
import com.shop.Entities.Product;
import com.shop.Exceptions.NoEntityException;
import com.shop.Repos.OrderRepository;
import com.shop.Repos.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public String index(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @PostMapping("loadAllProducts")
    public String loadAllProducts(Map<String,Object> model){
        model.put("allProducts",productRepository.findAll());
        return "main";
    }

    @PostMapping("loadAllOrders")
    public String loadAllOrders(Map<String,Object> model){
        model.put("allOrders",orderRepository.findAll());
        return "main";
    }

    @PostMapping("addProduct")
    public String addProduct(@RequestParam String productName, @RequestParam Double productPrice,
                             Map<String,Object> model){
       productRepository.save(new Product(productName,productPrice));
        return "main";
    }

    @PostMapping("addOrder")
    public String addOrder(@RequestParam String orderName, @RequestParam int quantity,
                           @RequestParam long productId,
                           Map<String,Object> model) throws NoEntityException{

        try {
            Product product = productRepository.findById(productId).orElseThrow(()
                    -> new NoEntityException(productId, "Ni"));
            orderRepository.save(new Order(product, quantity, orderName));
            Iterable<Order> allOrders = orderRepository.findAll();
            model.put("allOrders", allOrders);
            model.put("productAdding", "Product successfully added!");
        }catch (NoEntityException e){
            model.put("productAdding", "Product id - not found!");
        }
        return "main";
    }



}
