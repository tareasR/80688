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

        staticFiles.location("/");

        /**
         * Este método ya no es alcanzado, debido a que se ejecuta primero el location
         * raíz "/"
         */
        get("/", (req, res) -> "respuesta");
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
}
