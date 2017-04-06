package com.sv.websso.controller.opended;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InputController {


	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public ModelAndView hello() {

		ModelAndView model = new ModelAndView();
		model.setViewName("input");
		return model;

	}

}