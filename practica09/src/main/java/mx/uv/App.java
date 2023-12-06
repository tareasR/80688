package mx.uv;

import static spark.Spark.*;

import com.google.gson.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //fuente:https://gist.github.com/saeidzebardast/e375b7d17be3e0f4dddf
        options("/*",(request,response)->{
        String accessControlRequestHeaders=request.headers("Access-Control-Request-Headers");
        if(accessControlRequestHeaders!=null){
        response.header("Access-Control-Allow-Headers",accessControlRequestHeaders);
        }
        String accessControlRequestMethod=request.headers("Access-Control-Request-Method");
        if(accessControlRequestMethod!=null){
        response.header("Access-Control-Allow-Methods",accessControlRequestMethod);
        }
        return "OK";
        });
        before((request,response)->response.header("Access-Control-Allow-Origin","*"));

        
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
                (request, response) -> "{\"alumno\" : \"john\",\"matricula\" : \"s0001\",\"carrera\" : \"tc\"}"
        );

        post("/alumno", 
                (request, response) -> {
                        System.out.println(request.contentLength());
                        System.out.println(request.contentType());
                        System.out.println(request.contextPath());

                        return "profesor: "+request.queryParams("paterno");
                }
        );

        get("/tipousuario", (request, response) ->{
                JsonObject respuesta = new JsonObject();
                System.out.println("Este es el tipo de contenido: "+request.contentType());
                respuesta.addProperty("tipousuario", "profesor");
                respuesta.addProperty("nombre", request.queryParams("nombre"));
                respuesta.addProperty("paterno", request.queryParams("paterno"));
                respuesta.addProperty("materno", request.queryParams("materno"));
                //response.status(404);
                response.header("respuesta", "GET");
                // response.type("application/json");
                return respuesta;
        });

        post("/tipousuario", (request, response) ->{
                JsonObject respuesta = new JsonObject();
                System.out.println("Este es el tipo de contenido: "+request.contentType());
                respuesta.addProperty("tipousuario", "profesor");
                respuesta.addProperty("nombre", request.queryParams("nombre"));
                respuesta.addProperty("paterno", request.queryParams("paterno"));
                respuesta.addProperty("materno", request.queryParams("materno"));
                //response.status(404);
                response.header("respuesta", "POST");
                // response.type("application/json");
                return respuesta;
        });

        post("/json", (request, response)->{
                String peticion = request.body();
                System.out.println(peticion);

                JsonParser parser = new JsonParser();
                JsonElement arbol = parser.parse(peticion);
                return arbol.getAsJsonObject().get("nombre"); //.getAsString()¡;
        });
    }
}
