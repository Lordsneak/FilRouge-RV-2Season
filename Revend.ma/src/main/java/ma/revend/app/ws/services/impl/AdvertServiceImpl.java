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

import ma.revend.app.ws.entity.AdvertEntity;
import ma.revend.app.ws.repository.AdvertRepository;
import ma.revend.app.ws.services.AdvertService;
import ma.revend.app.ws.shared.Utils;
import ma.revend.app.ws.shared.dto.AdvertDto;

@Service
public class AdvertServiceImpl implements AdvertService{

	@Autowired
	AdvertRepository advertRepository;
	@Autowired
	Utils util;
	
	
	@Override
	public List<AdvertDto> getAdverts(int page, int limit) {

		if(page > 0) page = page -1;
		
		List<AdvertDto> advertDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<AdvertEntity> advertPage =	advertRepository.findAll(pageableRequest);
		
		List<AdvertEntity> adverts = advertPage.getContent();
		
		for(AdvertEntity advertEntity: adverts) {
			
			AdvertDto advert = new AdvertDto();
			
			BeanUtils.copyProperties(advertEntity, advert);
			
			advertDto.add(advert);
		}
		return advertDto;
		
	}

	@Override
	public AdvertDto createAdvert(AdvertDto advert) {
	
		
		AdvertEntity addadvert = new AdvertEntity();
		
		BeanUtils.copyProperties(advert, addadvert);
		
		addadvert.setAdvertId(util.generateStringId(5));
		
		AdvertEntity newAdvert = advertRepository.save(addadvert);
		
		AdvertDto advertDto = new AdvertDto();
		
		BeanUtils.copyProperties(newAdvert, advertDto);
		
		return advertDto;
	}

	@Override
	public AdvertDto getAdvert(String title) {
		
		AdvertEntity advertEntity = advertRepository.findByTitle(title);

		if (advertEntity == null)
			throw new UsernameNotFoundException(title);

		AdvertDto advertDto = new AdvertDto();

		BeanUtils.copyProperties(advertEntity, advertDto);

		return advertDto;
	}

	@Override
	public AdvertDto getAdvertByAdvertId(String advertId) {
		
		AdvertEntity advertEntity = advertRepository.findByAdvertId(advertId);

		if (advertEntity == null)
			throw new UsernameNotFoundException(advertId);

		AdvertDto advertDto = new AdvertDto();

		BeanUtils.copyProperties(advertEntity, advertDto);

		return advertDto;
		
	}

	@Override
	public AdvertDto getAdvertByPrice(String price) {
		
		AdvertEntity advertEntity = advertRepository.findByPrice(price);

		if (advertEntity == null)
			throw new UsernameNotFoundException(price);

		AdvertDto advertDto = new AdvertDto();

		BeanUtils.copyProperties(advertEntity, advertDto);

		return advertDto;
	}

	@Override
	public AdvertDto updateAdvert(String advertId, AdvertDto advertDto) {

		AdvertEntity advertEntity = advertRepository.findByAdvertId(advertId);
		
		if (advertEntity == null)
		throw new UsernameNotFoundException(advertId);

		
		advertEntity.setTitle(advertDto.getTitle());
		advertEntity.setDescription(advertDto.getDescription());
		advertEntity.setPrice(advertDto.getPrice());
		advertEntity.setImage(advertDto.getImage());

		AdvertEntity advertupdate = advertRepository.save(advertEntity);

		AdvertDto adve = new AdvertDto();

		BeanUtils.copyProperties(advertupdate, adve);

		return adve;
		
	}

	@Override
	public void deleteAdvert(String advertId) {
		
		AdvertEntity advertEntity = advertRepository.findByAdvertId(advertId);
		
		if (advertEntity == null)
			
			throw new UsernameNotFoundException(advertId);
		
		advertRepository.delete(advertEntity);
	}

}
