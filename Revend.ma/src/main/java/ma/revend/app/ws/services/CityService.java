package ma.revend.app.ws.services;

import java.util.List;

import ma.revend.app.ws.shared.dto.CityDto;


public interface CityService {
	
	List<CityDto> getCitys(int page, int limit);
	CityDto createCity(CityDto city);
	CityDto getCity(String name);
	CityDto getCityByCityId(String cityId);
	CityDto updateCity(String cityId, CityDto cityDto);
	void deleteCity(String cityId);

}
