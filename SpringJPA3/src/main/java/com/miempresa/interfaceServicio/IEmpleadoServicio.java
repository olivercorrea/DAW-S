package com.miempresa.interfaceServicio;

import java.util.List;
import java.util.Optional;

import com.miempresa.modelo.Empleado;

public interface IEmpleadoServicio {
	public List<Empleado> listar();
	public Optional<Empleado> listarId(int id);
	public int guardar(Empleado p);
	public void borrar(int id);
	
	public List<Empleado> buscar(String nombre);
}
