package mx.uv;

import static spark.Spark.*;

import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

import com.google.gson.*;

/**
 * Hello world!
 *
 */
public class App {
    private static Gson gson = new Gson();
    private static Usuario usuario = new Usuario("1", "john@htomail.com", "123456");
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Hello World!");
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

        get("/usuario", (req, res)-> {
            before((rq,rs)-> rs.type("application/json"));
            return gson.toJson(usuario);
        });

        get("/usuarios", (req, res)-> {
            before((rq,rs)-> rs.type("application/json"));
            return gson.toJson(usuarios.values());
        });

        post("/usuario", (req, res)-> {
            String payload = req.body();
            String id = UUID.randomUUID().toString();
            Usuario u = gson.fromJson(payload, Usuario.class);
            u.setId(id);
            usuarios.put(id, u);

            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", "ok");
            objetoJson.addProperty("id",  id);
            return objetoJson;

        });

        get("/pagina", (req, res)->{
            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("access", "ok");
            objetoJson.addProperty("page",  "http://www.google.com");
            return objetoJson;
        });
    }
}
