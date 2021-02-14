package com.jimmiemo.recipes.controller;

import com.jimmiemo.recipes.model.Ethnicity;
import com.jimmiemo.recipes.model.Recipe;
import com.jimmiemo.recipes.repository.EthnicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EthnicityController {
    @Autowired
    private EthnicityRepository ethnicityRepository;

    @PostMapping(path="/addEthnicity")
    public @ResponseBody
    String addEthnicity(@RequestParam String name) {
        Ethnicity ethnicity = new Ethnicity();
        ethnicity.setName(name);
        ethnicityRepository.save(ethnicity);
        return "Saved";
    }

    @GetMapping(path="/allEthnicities")
    public @ResponseBody Iterable<Ethnicity> getAllEthnicities() {
        return ethnicityRepository.findAll();
    }

    @GetMapping(path="/ethnicity")
    public @ResponseBody Ethnicity getOne(@RequestParam int id) {
        return ethnicityRepository.findById(id).orElse(null);
    }
}
