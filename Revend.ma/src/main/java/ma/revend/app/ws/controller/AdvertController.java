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

import ma.revend.app.ws.reponse.AdvertReponse;
import ma.revend.app.ws.request.AdvertRequest;
import ma.revend.app.ws.services.AdvertService;
import ma.revend.app.ws.shared.dto.AdvertDto;

@RestController
@RequestMapping("/ad")
public class AdvertController {

	@Autowired
	AdvertService advertService;
	

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertReponse> getAllAdverts(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {

		List<AdvertReponse> advertReponse = new ArrayList<>();

		List<AdvertDto> adverts = advertService.getAdverts(page, limit);

		for (AdvertDto advertDto : adverts) {
			
			AdvertReponse adverte = new AdvertReponse();

			BeanUtils.copyProperties(advertDto, adverte);

			advertReponse.add(adverte);
		}
		return advertReponse;
	}
	

	@GetMapping(path = "/{id}")
	public ResponseEntity<AdvertReponse> getAdvert(@PathVariable String id) {

		AdvertDto advertDto = advertService.getAdvertByAdvertId(id);

		AdvertReponse advertReponse = new AdvertReponse();

		BeanUtils.copyProperties(advertDto, advertReponse);

		return new ResponseEntity<AdvertReponse>(advertReponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AdvertReponse> createAdvert(@RequestBody AdvertRequest advertRequest) throws Exception {

		AdvertDto advertDto = new AdvertDto();

		BeanUtils.copyProperties(advertRequest, advertDto);

		AdvertDto createadvert = advertService.createAdvert(advertDto);

		AdvertReponse advertReponse = new AdvertReponse();

		BeanUtils.copyProperties(createadvert, advertReponse);

		return new ResponseEntity<AdvertReponse>(advertReponse, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<AdvertReponse> updateAdvert(@PathVariable String id, @RequestBody AdvertRequest advertRequest) {

		AdvertDto advertDto = new AdvertDto();

		BeanUtils.copyProperties(advertRequest, advertDto);

		AdvertDto updateAdvert = advertService.updateAdvert(id, advertDto);

		AdvertReponse advertReponse = new AdvertReponse();

		BeanUtils.copyProperties(updateAdvert, advertReponse);

		return new ResponseEntity<AdvertReponse>(advertReponse, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteAdvert(@PathVariable String id) {

		advertService.deleteAdvert(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
