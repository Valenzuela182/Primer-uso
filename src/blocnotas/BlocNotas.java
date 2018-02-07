
package blocnotas;

import dominio.LibroNotas;
import dominio.Nota;
import servicio.Utilidad;

/**
 *
 * @author Rodrigo
 */
public class BlocNotas {


    public static void main(String[] args) {
        int valor;
        LibroNotas libro=new LibroNotas();
        Utilidad.mostrarTexto("BLOC DE NOTAS");
        do{
            Utilidad.mostrarMenu();
            valor=Utilidad.recogerValor(1, 3, "Seleccione una opcion");
            if (valor==1){
                Nota n=Utilidad.tomarNota();
                libro.anadirNota(n);
            }else if (valor==2){
                Utilidad.mostrarNotas(libro.getNotas());
            }
        }while (valor!=3);
    }
    
}
