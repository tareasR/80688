package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;

import mx.uv.datos.Usuario;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App {
    private static Gson gson = new Gson();
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        port(getHerokuAssignedPort());

        staticFiles.location("/");

        // Enables CORS on requests. This method is an initialization method and should
        // be called once.

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

        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));
        

        /**
         * Este método ya no es alcanzado, debido a que se ejecuta primero el location
         * raíz "/"
         */
        // get("/", (req, res) -> "respuesta");
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(new ModelAndView(model, "index.html"));
        });

        get("/hola", (req, res) -> "hola mundo");
        get("/pagina", (req, res) -> {
            res.redirect("estatica.html");
            return null;
        });

        post("/usuario", (req, res) -> {
            String payload = req.body();
            String id = UUID.randomUUID().toString();
            Usuario u = gson.fromJson(payload, Usuario.class);
            u.setId(id);
            usuarios.put(id, u);

            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", "ok");
            objetoJson.addProperty("id", id);
            return objetoJson;
        });

        // do this
        get("/estatica", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(new ModelAndView(model, "estatica.html"));
        });

        // do this
        get("/velocity", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", "lo que sea!");
            model.put("apellido", "de tal!");
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/velocity.vm"));
        });

        // do this
        get("/usuarios", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("usuarios", usuarios.values());
            return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/velocity.vm"));
        });

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
