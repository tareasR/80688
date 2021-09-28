package mx.uv;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        get("/index.html", (a,b)->{
            Object req = a.headers("BAR");
            System.out.println(req);
            String h="<h1>hola</h1>";
            String f="<form><input type='text'><input type='submit'></form>";
            return req+h+f;
        });
        get("/alma.html", (a,b)->"alma");
        get("/juan.html", (a,b)->"juan");
        get("/dan.html", (a,b)->"dan");

        post("/hola.html", (a,b) -> "hola");
        get("/hola.html", (a,b) -> "no me llamo así");

        get("/saludar", (req, res)-> {
            String l = req.queryParams("nombre");
            String p = req.queryParams("password");
            String respuesta;

            if ( l.equals("root")  && p.equals("123456"))
                respuesta = "Bienvenido usuario ";
            else
                respuesta = "Usuario equivocado ";
            return respuesta + l;
        });
    }
}
