package mx.uv;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        get("/", 
                (request, response) -> "<h1>Bienvenidx</h1>"
        );
        get("/hola", 
                (request, response) -> "<h1>Hola mundo!</h1>"
        );
        get("/adios", 
                (request, response) -> "<h1>Adios mundo!</h1>"
        );
        get("/alumno", 
                (request, response) -> "{'alumno' : 'john','matricula' : 's0001','carrera' : 'tc'}"
        );
    }
}
