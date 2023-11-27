function eliminar(id){
	swal({
	  title: "¿Esta seguro?",
	  text: "¿Realmente desea eliminar este registro?",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((willDelete) => {
	  if (willDelete) {
	    location.href="/eliminarEmpleado/"+id;   
	  } else {
	    
	  }
	});
}
