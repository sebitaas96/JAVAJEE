package org.ssirbu.sesiones;

public class sesiones {
	//Crear u obtener una sesión ya iniciada.
	HttpSession sesion = request.getSession(true)
	//Consultar datos de sesión
	sesion.getId( )
	new Date(sesion.getCreationTime( ))
	new Date(sesion.getLastAccessedTime( ))
	//Guardar datos en la sesión
	sesion.setAttribute("numero", new Integer(10))
	//Recuperar datos de sesión
	(Integer) sesion.getAttribute("numero")
	//Eliminar un dato de la sesión
	sesion.removeAttribute("numero")
	//Destruir sesión
	sesion.invalidate( )

}
