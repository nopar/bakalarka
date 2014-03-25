package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Skupiny;
import com.sprhib.service.SkupinaService;

@Controller
@RequestMapping(value="/skupiny")
public class SkupinaController {
	
	@Autowired
	private SkupinaService krvnaSkupinaService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addKrvnaSkupinaPage() {
		ModelAndView modelAndView = new ModelAndView("add-krv-skup-form");
		modelAndView.addObject("krvnaskupina", new Skupiny());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingKrvnaSkupina(@ModelAttribute Skupiny krvnaSkupina) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		krvnaSkupinaService.addSkupina(krvnaSkupina);
		
		String message = "Krvna Skupina pridana.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
        
	@RequestMapping(value="/list")
	public ModelAndView listOfKrveSkupiny() {
		ModelAndView modelAndView = new ModelAndView("list-of-krv-skup");
		
		List<Skupiny> sk = krvnaSkupinaService.getSkupiny();
		modelAndView.addObject("sk", sk);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editKrvnaSkupinaPage(@PathVariable Integer id_group) {
		ModelAndView modelAndView = new ModelAndView("edit-krv-skup-form");
		Skupiny krvnaSkupina = krvnaSkupinaService.getSkupina(id_group);
		modelAndView.addObject("krvnaSkupina",krvnaSkupina);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingKrvnaSkupina(
                @ModelAttribute Skupiny krvnaSkupina, 
                @PathVariable Integer id_group) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		krvnaSkupinaService.updateSkupina(krvnaSkupina);
		
		String message = "Krvna skupina uspesne z-editovana.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteKrvnaSkupina(@PathVariable Integer id_group) {
		ModelAndView modelAndView = new ModelAndView("home");
		krvnaSkupinaService.deleteSkupina(id_group);
		String message = "Krvna skupina uspesne zmazana.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
