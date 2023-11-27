package com.miempresa.controlador;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miempresa.interfaceServicio.IEmpleadoServicio;
import com.miempresa.interfaceServicio.ITareaServicio;
import com.miempresa.modelo.Empleado;
import com.miempresa.modelo.Tarea;

@Controller
@RequestMapping
public class controlador {
	
	@Autowired
    private IEmpleadoServicio servicio;
	

	
	@GetMapping("/listarEmpleados")
    private String listarEmpleados(Model model) {
        List<Empleado> empleados = servicio.listar();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }
	
	@GetMapping("/agregarEmpleado")
    public String agregarEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "agregarEmpleado";
    }
	
	@PostMapping("/guardarEmpleado")
    public String guardarEmpleado(Empleado p) {
        servicio.guardar(p);
        return "redirect:/listarEmpleados";
    }
	
	@GetMapping("/editarEmpleado/{id}")
    public String editarEmpleado(@PathVariable int id, RedirectAttributes atributos) {
        Optional<Empleado> empleado = servicio.listarId(id);
        atributos.addFlashAttribute("empleado", empleado);
        return "redirect:/mostrarEmpleado";
    }

    @GetMapping("/mostrarEmpleado")
    public String mostrarEmpleado(@ModelAttribute("empleado") Empleado p, Model model) {
        model.addAttribute("empleado", p);
        return "agregarEmpleado";
    }
    
    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable int id) {
        servicio.borrar(id);
        return "redirect:/listarEmpleados";
    }
    
	//------
	@Autowired
	private ITareaServicio servici;
	
	@GetMapping("/listarTareas")
    private String listarTareas(Model model) {
        List<Tarea> tareas = servici.listar();
        model.addAttribute("tareas", tareas);
        return "tareas";
    }
	
	@GetMapping("/agregarTarea")
    public String agregarTarea(Model model) {
        model.addAttribute("tarea", new Tarea());
        return "agregarTarea";
    }
	
	@PostMapping("/guardarTarea")
    public String guardarTarea(Tarea p) {
        servici.guardar(p);
        return "redirect:/listarTareas";
    }
	
	@GetMapping("/editarTarea/{id}")
    public String editarTarea(@PathVariable int id, RedirectAttributes atributos) {
        Optional<Tarea> tarea = servici.listarId(id);
        atributos.addFlashAttribute("tarea", tarea);
        return "redirect:/mostrarTarea";
    }

    @GetMapping("/mostrarTarea")
    public String mostrarTarea(@ModelAttribute("tarea") Tarea p, Model model) {
        model.addAttribute("tarea", p);
        return "agregarTarea";
    }
    
    @GetMapping("/eliminarTarea/{id}")
    public String eliminarTarea(@PathVariable int id) {
        servici.borrar(id);
        return "redirect:/listarTareas";
    }
	//------
    
    //------
    @GetMapping("/buscarEmpleados")
    public String buscarEmpleados(@RequestParam(name="nombre") String nombre, Model model) {
    	System.out.println("nombre");
    	List<Empleado> empleados = servicio.buscar(nombre);
    	model.addAttribute("empleados", empleados);
        return "buscarEmpleado";
    }
    //------
    
    //------
    @GetMapping("/buscarTareas")
    public String buscarTareas(@RequestParam(name="descripcion") String descripcion, Model model) {
    	System.out.println("nombre");
    	List<Tarea> tareas = servici.buscar(descripcion);
    	model.addAttribute("tareas", tareas);
        return "buscarTarea";
    }
    //------
    
    
    
    //---- Buscar ambos -----
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "nombre", required = false) String nombre,
                         @RequestParam(name = "descripcion", required = false) String descripcion,
                         Model model) {
        if (nombre != null && !nombre.isEmpty()) {
            List<Empleado> empleados = servicio.buscar(nombre);
            model.addAttribute("empleados", empleados);
            return "buscarEmpleado";
        }

        if (descripcion != null && !descripcion.isEmpty()) {
            List<Tarea> tareas = servici.buscar(descripcion);
            model.addAttribute("tareas", tareas);
            return "buscarTarea";
        }

        model.addAttribute("empleados", Collections.emptyList());
        return "buscarEmpleado";
    }

    
    //-----------------------
}
