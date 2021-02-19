
package edu.escuelaing.arem.server;

import static spark.Spark.get;
import static spark.Spark.port;

import edu.escuelaing.arem.util.Calculator;
import org.json.JSONObject;

public class CalcSpark {
    public static void main(String[] args) {
        Calculator calc = new Calculator ();
        port (getPort ());
        get ("/Respuesta", (request, response) -> {
            response.type ("application/json");
            String tipo = request.queryParams ("tipo");
            Double numero = Double.parseDouble ( request.queryParams("numero"));
            numero = calc.Calcular (numero,tipo);
            JSONObject json = new JSONObject ();
            json.put ("numero",numero);
            return json;
        });
    }




    static int getPort() {
        if (System.getenv ("PORT") != null) {
            return Integer.parseInt (System.getenv ("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
