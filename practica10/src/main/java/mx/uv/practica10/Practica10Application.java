package mx.uv.practica10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Practica10Application {

	public static void main(String[] args) {
		SpringApplication.run(Practica10Application.class, args);
	}

	@RequestMapping("/")
	String home(){
		return "<h1>Bienvenido al API</h1>"+
			"<p>opciones del api</p>" +
			"<ol>"+
			"<li>/altas</li>"+
			"<li>/bajas</li>"+
			"<li>/cambios</li>"+
			"<li>/consultas</li>";
	}
	@RequestMapping("/altas")
	String altas(){
		return "producto dado de alta";
	}
	@RequestMapping("/bajas")
	String bajas(){
		return "producto dado de baja";
	}
	@RequestMapping("/cambios")
	String cambios(){
		return "producto modificado";
	}
	@RequestMapping("/consultas")
	String consultas(){
		return "producto consultado";
	}
	
}
