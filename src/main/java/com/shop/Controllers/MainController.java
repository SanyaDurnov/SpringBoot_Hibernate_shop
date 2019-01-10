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
public class MainController  {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public String index(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String test(@RequestParam(defaultValue = "") String orderName, Map<String,Object> model){
        if (!orderName.isEmpty() && orderName!=null ){
            model.put("allOrders",orderRepository.findByOrderName(orderName));
        }else
            model.put("allOrders",orderRepository.findAll());
        model.put("allProducts",productRepository.findAll());
        return "test";
    }

    @PostMapping("delProductById")
    public String delProductById(@RequestParam(required = false) long id){
        try {
            productRepository.deleteById(id);
        }
        catch (Exception e){return "redirect:/main";}
        return "redirect:/main";
    }

    @PostMapping("addProduct")
    public String addProduct(@RequestParam String productName, @RequestParam Double productPrice,
                             Map<String,Object> model){
       productRepository.save(new Product(productName,productPrice));
        return "redirect:/main";
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
        return "redirect:/main";
    }



}
