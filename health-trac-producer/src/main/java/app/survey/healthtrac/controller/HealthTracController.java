package app.survey.healthtrac.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.survey.healthtrac.exception.ApplicationException;
import app.survey.healthtrac.model.FormHealthStatus;
import app.survey.healthtrac.model.OutHealthStatus;
import app.survey.healthtrac.service.HealthTracService;
import app.survey.healthtrac.util.AppResponse;
import app.survey.healthtrac.util.SearchByEnum;
import app.survey.healthtrac.util.UrlMapping;
import app.survey.healthtrac.util.ValidatorUtils;

@RestController
@RequestMapping(UrlMapping.FRONT_CONTROLLER)
public class HealthTracController {
	
	private HealthTracService healthTracService;
	
	public HealthTracController(HealthTracService healthTracService) {
		this.healthTracService = healthTracService;
	}
	
	@PostMapping(value = UrlMapping.FRONT_CONTROLLER_SAVE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public AppResponse<String> saveHealthStatus(@RequestBody @Valid FormHealthStatus formHealthStatus, BindingResult br) {
		if(br.hasErrors()) { throw new ApplicationException(br.getAllErrors().parallelStream().map(t->t.getDefaultMessage()).reduce((t1,t2)->(t1+", "+t2)).orElse(null)); }
		
		return null;
	}
	
	@GetMapping(value = UrlMapping.FRONT_CONTROLLER_FETCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public AppResponse<List<OutHealthStatus>> getHealthStatus(@PathVariable(name = "searchBy",required = true) String searchBy, @PathVariable(name = "searchText",required = true) String searchText) {
		SearchByEnum searchByEnum = ValidatorUtils.validateSearchBy(searchBy);
		return null;
		
	}
}
