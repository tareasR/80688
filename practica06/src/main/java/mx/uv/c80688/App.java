package mx.uv.c80688;
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
        get("/aaron", (req, res) -> "Hello Aaron");
        get("/omar", (req, res) -> "Hello omar");
        get("/eduardo", (req, res) -> "Hello eduardo");
        get("/", (req, res) -> "<h1>Hola Sistemas Web</h1><img src='https://www.uv.mx/v2/images/logouv.jpg'>");

    }
}
