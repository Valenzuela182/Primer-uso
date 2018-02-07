
package dominio;

import java.util.Calendar;

/**
 *
 * @author Rodrigo Valenzuela
 */
public class Nota {
    public Nota(){}
    private String texto;
    private Calendar fecha;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    
    
}
