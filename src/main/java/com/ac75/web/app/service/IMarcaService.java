package com.ac75.web.app.service;

import java.util.List;

import com.ac75.web.app.domain.Marca;

public interface IMarcaService {

	Marca save(Marca marca);
	
	List<Marca> getAllMarcas();
	
	void update(Marca marca, Long idMarca);
	
	Marca getById(Long id);
	
	void delete(Long id);
	
}
