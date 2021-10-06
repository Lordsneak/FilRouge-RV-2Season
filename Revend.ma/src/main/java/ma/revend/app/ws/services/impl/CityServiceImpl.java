package ma.revend.app.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.revend.app.ws.entity.CityEntity;
import ma.revend.app.ws.repository.CityRepository;
import ma.revend.app.ws.services.CityService;
import ma.revend.app.ws.shared.Utils;
import ma.revend.app.ws.shared.dto.CityDto;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	CityRepository cityRepository;
	@Autowired
	Utils util;
	
	
	
	@Override
	public List<CityDto> getCitys(int page, int limit) {
		
		if(page > 0) page = page -1;
		
		List<CityDto> cityDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<CityEntity> cityPage =	cityRepository.findAll(pageableRequest);
		
		List<CityEntity> citys = cityPage.getContent();
		
		for(CityEntity cityEntity: citys) {
			
			CityDto city = new CityDto();
			
			BeanUtils.copyProperties(cityEntity, city);
			
			cityDto.add(city);
		}
		return cityDto;
	}

	@Override
	public CityDto createCity(CityDto city) {
		
		CityEntity checkprod = cityRepository.findByName(city.getName());
		
		if(checkprod != null) throw new RuntimeException("City Already Exists");
		
		CityEntity addcity = new CityEntity();
		
		BeanUtils.copyProperties(city, addcity);
		
		addcity.setCityId(util.generateStringId(3));
		
		CityEntity newcity = cityRepository.save(addcity);
		
		CityDto cityDto = new CityDto();
		
		BeanUtils.copyProperties(newcity, cityDto);
		
		return cityDto;
	}

	@Override
	public CityDto getCity(String name) {
		
		CityEntity cityEntity = cityRepository.findByName(name);

		if (cityEntity == null)
			throw new UsernameNotFoundException(name);

		CityDto cityDto = new CityDto();

		BeanUtils.copyProperties(cityEntity, cityDto);

		return cityDto;
	}

	@Override
	public CityDto getCityByCityId(String cityId) {
		
		CityEntity cityEntity = cityRepository.findByCityId(cityId);

		if (cityEntity == null)
			throw new UsernameNotFoundException(cityId);

		CityDto cityDto = new CityDto();

		BeanUtils.copyProperties(cityEntity, cityDto);

		return cityDto;
	}

	@Override
	public CityDto updateCity(String cityId, CityDto cityDto) {
		
		CityEntity cityEntity = cityRepository.findByCityId(cityId);
		if (cityEntity == null)
		throw new UsernameNotFoundException(cityId);

		
		cityEntity.setName(cityDto.getName());

		CityEntity cityupdate = cityRepository.save(cityEntity);

		CityDto cityd = new CityDto();

		BeanUtils.copyProperties(cityupdate, cityd);

		return cityd;
	}

	@Override
	public void deleteCity(String cityId) {
		
		CityEntity cityEntity = cityRepository.findByCityId(cityId);

		if (cityEntity == null)
			throw new UsernameNotFoundException(cityId);

		cityRepository.delete(cityEntity);
		
	}

}
