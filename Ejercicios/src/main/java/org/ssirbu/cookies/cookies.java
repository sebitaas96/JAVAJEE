package org.ssirbu.cookies;

public class cookies {
	Crear una cookie
	Cookie c=new Cookie(”Nombre”,”valor”)
	Modificar la cookie
	c.setValue(”Otro valor”); c.setMaxAge(24000); //6h.en segundos
	Enviarla al cliente (antes del primer “print”)
	response.addCookie(c)
	Recuperar cookies
	Cookie[ ] cs = request.getCookies( )
	Comprobar si hay alguna cookie
	if (cs != null && cs.length > 0) { … }
	Acceso a los datos de cada cookie del array
	cs[indice].getName( )
	cs[indice].getValue( )
	Destruir una cookie
	 c.setMaxAge(0)
	Codificando / decodificando los caracteres “raros” de las cookies (nombre y/o valor)
	URLEncoder.encode( datoDeCookie , “UTF-8”)
	URLDecoder.decode( datoDeCookie , “UTF-8”)

	
	
	
}
