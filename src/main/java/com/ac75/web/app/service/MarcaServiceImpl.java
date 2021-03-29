package com.ac75.web.app.service;

import java.util.List;

import javax.persistence.OrderBy;
import java.util.Optional;

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

	@Override
	public Marca save(Marca marca) {		
		return marcaRepository.save(marca);
	}

	@Override
	public void update(Marca marca, Long idMarca) {
		marcaRepository.findById(idMarca).ifPresent((x)->{
			marca.setId(idMarca);
			marcaRepository.save(marca);
		});
		
	}

	@Override
	public Marca getById(Long id) {
		Optional<Marca> obj = marcaRepository.findById(id);;
		if (obj.isPresent()) {
			return obj.get();
		} 
		
		return null;
	}

	@Override
	public void delete(Long id) {
		marcaRepository.deleteById(id);		
	}
	
	

}
