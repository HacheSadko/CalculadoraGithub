package servletHTML;

/**
 *
 * @author Pablo
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.*;

public class ServletCalculadora extends HttpServlet {
    String nombre;

    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
                double result;
                double numero1;
                double numero2;
                String operacion;
            try{            
                result = 0;
                numero1 = Double.parseDouble(peticion.getParameter("NUMERO1"));
                numero2 = Double.parseDouble(peticion.getParameter("NUMERO2"));
                operacion = peticion.getParameter("OPERACION");
                if(null == operacion)
               {}
               else
               switch (operacion) {
                case "+":
                    result=numero1+numero2;
                    break;
                case "-":
                    result=numero1-numero2;                 
                    break;
                case "/":
                    result=numero1/numero2;
                    break;
                case "^":
                    result=Math.pow(numero1, numero2);
                    break;
                case "abs":
                    result=(int) Math.abs(numero1);
                    break;
                case "round":
                    result=(int) Math.round(numero1);
                    break;
                case "*":
                    result=numero1*numero2;
                    break;   
                default:
                    break;
                    
            }
            }
            catch(Exception e)
            {
                result = 0;
                numero1 = Double.parseDouble(peticion.getParameter("NUMERO1"));
                operacion = peticion.getParameter("OPERACION");
                if(null == operacion)
               {}
               else
               switch (operacion) {
                case "abs":
                    result=(int) Math.abs(numero1);
                    break;
                case "round":
                    result=(int) Math.round(numero1);
                    break; 
                case "sen":
                    result= Math.asin(numero1);
                    break;   
                case "cos":
                    result= Math.acos(numero1);
                    break;  
                case "tan":
                    result= Math.atan(numero1);
                    break;  
                default:
                    break;
            }
            }
                    
               
        PrintWriter out = new PrintWriter(respuesta.getOutputStream());
        out.println("<html>");
        out.println("<head><title>Respuesta de la Calculadora de Servlet</title></head>");
        out.println("<body>");
        out.println("<p><h1><center>La respuesta es:   <B>" + result + "</B> </center></h1></p>");
        out.println("</body></html>");
        out.close();
    }
}
