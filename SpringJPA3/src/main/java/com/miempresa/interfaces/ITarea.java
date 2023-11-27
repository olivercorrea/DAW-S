package com.miempresa.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miempresa.modelo.Tarea;

@Repository
public interface ITarea extends CrudRepository<Tarea, Integer>{
	List<Tarea> findByDescripcion(String descripcion);
}
