package com.ac75.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac75.web.app.domain.Marca;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Long>{
	
	

}
