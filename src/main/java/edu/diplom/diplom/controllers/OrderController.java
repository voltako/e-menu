package edu.diplom.diplom.controllers;

import edu.diplom.diplom.models.Dish;
import edu.diplom.diplom.models.Zakaz;
import edu.diplom.diplom.repo.DishRepository;
import edu.diplom.diplom.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class OrderController {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public String Zakaz(Model model) {
        Iterable<Zakaz> orders = orderRepository.findAll();
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/newOrder")
    public String newOrder(Model model) {
            Iterable<Dish> dishs = dishRepository.findAll();
            model.addAttribute("dishs",dishs);
            return "newOrder";
        }

    @GetMapping("/zakaz")
    public String zakaz(Model model) {
        return "newOrder";
    }

    }
