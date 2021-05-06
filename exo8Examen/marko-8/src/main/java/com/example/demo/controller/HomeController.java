package com.example.demo.controller;


import com.example.demo.model.Ingredient;
import com.example.demo.request_model.RequestIngredient;
import com.example.demo.request_model.RequestMeal;
import com.example.demo.model.Meal;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "", allowedHeaders = "")
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    MealRepository mealRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("/")
    public String home(Model model){
        List<Meal> meals = mealRepository.findAll();
        Random r = new Random();
        int upperbound = meals.size();

        List<Meal> m = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 3) {
            set.add(r.nextInt(upperbound));
        }
        for(int i : set){
            m.add(meals.get(i));
        }

        RequestMeal rm = new RequestMeal();
        RequestIngredient ri = new RequestIngredient();

        model.addAttribute("meals", m);
        model.addAttribute("rm", rm);
        model.addAttribute("ing", ri);
        model.addAttribute("page", "Home");
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAdd(@ModelAttribute("rm") RequestMeal meal, Model model){

        System.out.println("meal");
        System.out.println(meal);
        String titre = meal.getTitre();
        String lienImage = meal.getLienImage();
        String preparation = meal.getPreparation();
        String cuisson = meal.getCuisson();


        Meal m = new Meal();
        m.setTitre(titre);
        m.setLienImage(lienImage);
        m.setCuisson(cuisson);
        m.setPreparation(preparation);

        mealRepository.save(m);
        List<Meal> meals = mealRepository.findAll();
        Random r = new Random();
        int upperbound = meals.size();

        List<Meal> mm = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 3) {
            set.add(r.nextInt(upperbound));
        }
        for(int i : set){
            mm.add(meals.get(i));
        }
        RequestMeal rm = new RequestMeal();
        RequestIngredient ri = new RequestIngredient();

        model.addAttribute("meals", mm);
        model.addAttribute("rm", rm);
        model.addAttribute("ing", ri);
        model.addAttribute("page", "Add Meal");
        return "index";
    }


    @RequestMapping(value = "/addIng", method = RequestMethod.POST)
    public String addIng(@ModelAttribute("ing") RequestIngredient ri, Model model){
        System.out.println("ingredient");
        System.out.println(ri);

        List<Meal> meals = mealRepository.findAll();
        Random r = new Random();
        int upperbound = meals.size();

        List<Meal> m = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 3) {
            set.add(r.nextInt(upperbound));
        }
        for(int i : set){
            m.add(meals.get(i));
        }

        RequestMeal rm = new RequestMeal();
        RequestIngredient rii = new RequestIngredient();

        model.addAttribute("meals", m);
        model.addAttribute("rm", rm);
        model.addAttribute("ing", rii);
        model.addAttribute("page", "Add Ingredient");
        return "index";
    }
}