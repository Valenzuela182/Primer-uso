
package dominio;

import java.util.ArrayList;
import java.util.List;
import servicio.Utilidad;

/**
 *
 * @author Rodrigo
 */
public class LibroNotas {
    private List<Nota> notas;
    public LibroNotas(){
        this.notas=new ArrayList<>();
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
    
    public boolean anadirNota(Nota nota){
        this.notas.add(nota);
        this.notas=Utilidad.ordenarNotasBurbujaFecha(this.notas);
        return true;
    }
}
