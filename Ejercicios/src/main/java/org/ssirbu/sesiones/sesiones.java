package org.ssirbu.sesiones;

public class sesiones {
	//Crear u obtener una sesi�n ya iniciada.
	HttpSession sesion = request.getSession(true)
	//Consultar datos de sesi�n
	sesion.getId( )
	new Date(sesion.getCreationTime( ))
	new Date(sesion.getLastAccessedTime( ))
	//Guardar datos en la sesi�n
	sesion.setAttribute("numero", new Integer(10))
	//Recuperar datos de sesi�n
	(Integer) sesion.getAttribute("numero")
	//Eliminar un dato de la sesi�n
	sesion.removeAttribute("numero")
	//Destruir sesi�n
	sesion.invalidate( )

}
