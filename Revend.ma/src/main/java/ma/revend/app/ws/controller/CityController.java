package ma.revend.app.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.revend.app.ws.reponse.CityReponse;
import ma.revend.app.ws.request.CityRequest;
import ma.revend.app.ws.services.CityService;
import ma.revend.app.ws.shared.dto.CityDto;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;
	
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CityReponse> getAllCitys(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {

		List<CityReponse> cityReponse = new ArrayList<>();

		List<CityDto> citys = cityService.getCitys(page, limit);

		for (CityDto cityDto : citys) {
			
			CityReponse cit = new CityReponse();

			BeanUtils.copyProperties(cityDto, cit);

			cityReponse.add(cit);
		}
		return cityReponse;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CityReponse> getCity(@PathVariable String id) {

		CityDto cityDto = cityService.getCityByCityId(id);

		CityReponse cityReponse = new CityReponse();

		BeanUtils.copyProperties(cityDto, cityReponse);

		return new ResponseEntity<CityReponse>(cityReponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CityReponse> createCity(@RequestBody CityRequest cityRequest) throws Exception {

		CityDto cityDto = new CityDto();

		BeanUtils.copyProperties(cityRequest, cityDto);

		CityDto createCity = cityService.createCity(cityDto);

		CityReponse cityReponse = new CityReponse();

		BeanUtils.copyProperties(createCity, cityReponse);

		return new ResponseEntity<CityReponse>(cityReponse, HttpStatus.CREATED);
	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<CityReponse> updateCity(@PathVariable String id, @RequestBody CityRequest cityRequest) {

		CityDto cityDto = new CityDto();

		BeanUtils.copyProperties(cityRequest, cityDto);

		CityDto updateCity = cityService.updateCity(id, cityDto);

		CityReponse cityReponse = new CityReponse();

		BeanUtils.copyProperties(updateCity, cityReponse);

		return new ResponseEntity<CityReponse>(cityReponse, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteCity(@PathVariable String id) {

		cityService.deleteCity(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
