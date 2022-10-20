package mx.uv.c80688;

import static spark.Spark.*;

import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // fuente: https://gist.github.com/saeidzebardast/e375b7d17be3e0f4dddf
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        System.out.println("Hello World!");
        get("/aaron", (req, res) -> "Hello Aaron");
        get("/omar", (req, res) -> "Hello omar");
        get("/eduardo", (req, res) -> "Hello eduardo");
        get("/", (req, res) -> "<h1>Hola Sistemas Web</h1><img src='https://www.uv.mx/v2/images/logouv.jpg'>");
        post("/", (req, res) -> {
            System.out.println("login: " + req.queryParams("login"));
            System.out.println("contraseña: " + req.queryParams("password"));
            String usuario = req.queryParams("login");

            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("msj", "bienvenido");
            respuesta.addProperty("usuario", usuario);

            if (usuario.equals("omar")) {
                res.status(200);
                return respuesta;
            } else {
                res.status(404);
                return "Quien eres tu? " + usuario;
            }
        });
    }
}
