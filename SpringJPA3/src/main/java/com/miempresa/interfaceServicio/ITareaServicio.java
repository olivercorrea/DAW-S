package com.miempresa.interfaceServicio;

import java.util.List;
import java.util.Optional;

import com.miempresa.modelo.Tarea;

public interface ITareaServicio {
	public List<Tarea> listar();
	public Optional<Tarea> listarId(int id);
	public int guardar(Tarea p);
	public void borrar(int id);
	
	public List<Tarea> buscar(String descripcion);
}
