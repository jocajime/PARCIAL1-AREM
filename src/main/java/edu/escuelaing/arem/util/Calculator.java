package edu.escuelaing.arem.util;

public class Calculator {


    public Double Calcular(Double numero, String tipo){
        if (tipo == "sin"){
            return Math.sin(numero);
        } else if (tipo == "cos"){
            return Math.cos(numero);
        } else if (tipo == "tan"){
            return Math.tan(numero);
        } else{
            return 0.0;
        }
    }

}
