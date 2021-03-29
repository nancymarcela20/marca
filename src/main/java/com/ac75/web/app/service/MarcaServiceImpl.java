package com.ac75.web.app.service;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac75.web.app.domain.Marca;
import com.ac75.web.app.repository.IMarcaRepository;

@Service
public class MarcaServiceImpl implements IMarcaService{

	@Autowired
	private IMarcaRepository marcaRepository;
	
	@Override
	public List<Marca> getAllMarcas() {		
		return marcaRepository.findAll();
	}
	
	

}
