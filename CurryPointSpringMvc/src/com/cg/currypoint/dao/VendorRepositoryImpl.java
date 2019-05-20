package com.cg.currypoint.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.cg.currypoint.dto.Vendor;

@Repository
public class VendorRepositoryImpl implements VendorRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Vendor save(Vendor vendor) {
		entityManager.persist(vendor);
		entityManager.flush();
		return vendor;
	}

	@Override
	public List<Vendor> findByLocation(String city) {
		Query query=entityManager.createQuery(QueryRepository.FIND_BY_LOCATION);
		query.setParameter("city", city);
		return query.getResultList();
	}

	@Override
	public List<Vendor> findByName(String name) {
		Query query=entityManager.createQuery(QueryRepository.FIND_BY_NAME);
		query.setParameter("name", name);
		return query.getResultList();
	}
}
