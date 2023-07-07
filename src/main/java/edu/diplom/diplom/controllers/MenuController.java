package edu.diplom.diplom.controllers;

import edu.diplom.diplom.models.Dish;
import edu.diplom.diplom.repo.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MenuController {

    @Autowired
    private DishRepository dishRepository;


    @GetMapping("/predmenu")
    public String Menu(Model model) {
        Iterable<Dish> dishs = dishRepository.findAll();
        model.addAttribute("dishs",dishs);
        return "predmenu";
    }

    @GetMapping("/menu/add")
    public String MenuAdd(Model model) {
        Iterable<Dish> dishs = dishRepository.findAll();
        model.addAttribute("dishs",dishs);
        return "menu-add";
    }

    @PostMapping("/menu/add")
    public String MenuDinnerAdd(@RequestParam String Name,@RequestParam String Ingredients,@RequestParam Double cost, Model model){
        Dish dish = new Dish(Name,Ingredients,cost);
        dishRepository.save(dish);
        return "redirect:/predmenu";
    }

    @GetMapping("/menu-prededit")
    public String MenuDinnerPredEdit(Model model) {
        Iterable<Dish> dishs = dishRepository.findAll();
        model.addAttribute("dishs",dishs);
        return "menu-prededit";
    }

    @PostMapping("/menu-prededit")
    public String MenuDinnerPredEdit(@RequestParam String Name,@RequestParam String Ingredients,@RequestParam Double cost, Model model){
        Dish dish = new Dish(Name,Ingredients,cost);
        dishRepository.save(dish);
        return "redirect:/menu-prededit";
    }

    @GetMapping("/menu/{id}/edit")
    public String MenuEdit(@PathVariable(value = "id") long id, Model model) {
        if(!dishRepository.existsById(id)){
            return "menu-edit";
        }

        Optional<Dish> dish =  dishRepository.findById(id);
        ArrayList<Dish> res = new ArrayList<>();
        dish.ifPresent(res::add);
        model.addAttribute("dish",res);
        return "menu-edit";
    }

    @PostMapping("/menu/{id}/edit")
    public String DishMenuEdit(@PathVariable(value = "id") long id,@RequestParam String Name,@RequestParam String Ingredients,@RequestParam Double cost, Model model){
        Dish dish = dishRepository.findById(id).orElseThrow();
        dish.setName(Name);
        dish.setIngredients(Ingredients);
        dish.setCost(cost);
        dishRepository.save(dish);
        return "redirect:/menu-prededit";
    }

    @PostMapping("/menu/{id}/remove")
    public String DishMenuDelete(@PathVariable(value = "id") long id, Model model){
        Dish dish = dishRepository.findById(id).orElseThrow();
        dishRepository.delete(dish);
        return "redirect:/menu-prededit";
    }

}
