package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired // Instantiate
	private CityService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<City> listCity = service.listAll();
		model.addAttribute("listCity", listCity);
		return "index";
	}
	
	@RequestMapping("/new")
	// match the <a href="new">Create A New Weather Report</a> in index.html
	public String showNewReport(Model model) {
		City city = new City();
		model.addAttribute("city", city); 
		return "WeatherReport";
	}
	
	// match the (th:action="@{/save}) in the <form></form> of WratherReport.html, EditReport.html
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCity(@ModelAttribute("city") City city) {
		// @ModelAttribute("city") is the annotation applied to the City city
		// so that the City city can connects to the WeatherReport.html
		// must match (th:object="${city}") in the WeatherReport.html
		service.save(city); // store the city into the database
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	// second way for the request
	public ModelAndView editReport(@PathVariable(name = "id") int id) {
		// @PathVariable(name = "id") -> take the id in the URL
		ModelAndView M = new ModelAndView("EditReport");
		City city = service.get(id);
		M.addObject("city", city); 
		// active the (th:action="@{/save}) in the <form></form> of EditReport.html
		// then active the saveCity()
		return M;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteReport(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
