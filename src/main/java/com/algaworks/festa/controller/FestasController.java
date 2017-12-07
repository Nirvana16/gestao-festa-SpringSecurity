package com.algaworks.festa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.festa.filter.FestaFilter;
import com.algaworks.festa.model.Festa;
import com.algaworks.festa.repository.Festas;

@Controller
@RequestMapping("/festas")
public class FestasController {

	private static final String FRM = "FrmFestas";
	private static final String LIS = "ListaFestas";

	@Autowired
	private Festas festas;

	@RequestMapping()
	public ModelAndView listar(@ModelAttribute("filtro") FestaFilter filtro) {
		ModelAndView mv = new ModelAndView(LIS);
		mv.addObject("festas",festas.findAll());
		return mv;
	}

	//Novo
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(FRM);
		mv.addObject(new Festa());
		return mv;
	}

	//Salvar
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Festa festa, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return FRM;
		}

		try {
			this.festas.save(festa);
			attributes.addFlashAttribute("mensagem", "Festa salva com sucesso!");
			return "redirect:/festas/novo";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return FRM;
		}
	}


	//Editar
	@RequestMapping(value = "/alterar/{id}")
	public ModelAndView edicao(@PathVariable("id") Festa festa) {
		ModelAndView mv = new ModelAndView(FRM); 
		mv.addObject(festa);
		return mv;
	}

	//Excluir
	@RequestMapping(value = "/excluir/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		festas.delete(id);
		attributes.addFlashAttribute("mensagem", "Festa excluída com sucesso!");
		return "redirect:/festas";
	}


	

}