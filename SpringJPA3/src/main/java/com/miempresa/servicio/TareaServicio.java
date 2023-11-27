package com.miempresa.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.interfaces.ITarea;
import com.miempresa.modelo.Tarea;


import com.miempresa.interfaceServicio.ITareaServicio;

@Service
public class TareaServicio implements ITareaServicio{
	
	@Autowired
	private ITarea repo;
	
	@Override
	public List<Tarea> listar() {
		return (List<Tarea>)repo.findAll();
	}

	@Override
	public Optional<Tarea> listarId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public int guardar(Tarea p) {
		Tarea em = repo.save(p);
		if (!em.equals(null)) {
	        return 1;
	    }
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);		
	}

	@Override
	public List<Tarea> buscar(String descripcion) {
		// TODO Auto-generated method stub
		return (List<Tarea>)repo.findByDescripcion(descripcion);
	}
}
