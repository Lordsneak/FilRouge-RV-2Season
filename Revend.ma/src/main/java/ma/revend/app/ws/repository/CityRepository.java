package ma.revend.app.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.revend.app.ws.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
	
	CityEntity findByName(String name);
	CityEntity findByCityId(String cityId);

}
