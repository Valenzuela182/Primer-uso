
package servicio;

import dominio.Nota;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Rodrigo Valenzuela
 */
public class Utilidad {
    private static BufferedReader br=null;
    public static void mostrarMenu(){
        System.out.println("1.- Insertar nota");
        System.out.println("2.- Ver notas");
        System.out.println("3.- Salir");
        System.out.println("****");
    }
    public static Nota tomarNota(){
        mostrarTexto("--NUEVA NOTA--");
        Calendar fecha = recogerFecha("-FECHA-");
        mostrarTexto("-TEXTO-");
        String texto=recogerTexto("Nota");
        Nota n=new Nota();
        n.setFecha(fecha);
        n.setTexto(texto);
        return n;
    }
    public static void mostrarNotas(List<Nota> notas){
        if ((notas!=null)&&(!notas.isEmpty())){
            System.out.println("--LISTADO DE NOTAS--");
            int i=1;
            for (Nota n:notas){
                Calendar fecha=n.getFecha();
                String texto=n.getTexto();
                String fechaCadena=convertirFechaCadena(fecha);
                System.out.println("Nota "+i+". Fecha: "+fechaCadena+". Nota: "+texto+".");
                i++;
                }
            }else{
                mostrarTexto(": No existen notas que mostrar.");
            }
        }
    public static void mostrarTexto(String textoMostrar){
        System.out.println(textoMostrar);
    }
            public static String recogerTexto(String textoMostrar){
                if (br==null) br=new BufferedReader(new InputStreamReader(System.in));
                String entrada=null;
                while (entrada==null){
                    System.out.println(textoMostrar+": ");
                    try{
                        entrada=br.readLine();
                    }catch(Exception e){}
                }
                return entrada;
                    }
            public static int recogerValor(int min, int max, String textoMostrar){
                if (br==null) br=new BufferedReader(new InputStreamReader(System.in));
                String entrada;
                int value=-1000;
                while ((value<min)||(value>max)){
                    System.out.println(textoMostrar+": ");
                    try{
                        entrada=br.readLine();
                        value=Integer.parseInt(entrada);
                    }catch(Exception e){}
                }
                return value;
            }
            public static Calendar recogerFecha(String textoMostrar){
                if (br==null) br=new BufferedReader(new InputStreamReader(System.in));
                System.out.println(textoMostrar);
                mostrarMeses();
                int mes=recogerValor(1,12,"Seleccione mes");
                int ano=recogerValor(2016,2030,"Seleccione año entre 2016 y 2030");
                int dia=0;
                if ((mes==1)||(mes==3)||(mes==5)||(mes==7)||(mes==8)||(mes==10)||(mes==12)){
                    dia=recogerValor(1,31,"Seleccione el dia entre 1 y 31");
                    }else{
                    if(mes==2){
                        if(esBisiesto(ano)){
                            dia=recogerValor(1,29,"Seleccione el dia entre 1 y 29");
                        }else{
                            dia=recogerValor(1,28,"Seleccione el dia entre 1 y 28");
                        }
                    }else{
                        dia=recogerValor(1,30,"Seleccione el dia entre 1 y 30");
                    }
                }
                mes=mes-1;
                return new GregorianCalendar(ano,mes,dia);
            }
            private static String convertirFechaCadena(Calendar fecha){
                int ano=fecha.get(Calendar.YEAR);
                int mes=fecha.get(Calendar.MONTH)+1;
                int dia=fecha.get(Calendar.DAY_OF_MONTH);
                String anoString=""+ano;
                String mesString=(mes<10)?"0"+mes:""+mes;
                String diaString=(dia<10)?"0"+dia:""+dia;
                String fechaString=diaString+"/"+mesString+"/"+anoString;
                return fechaString;
            }
            private static void mostrarMeses(){
                System.out.println("Los meses del año");
                System.out.println("1.- Enero");
                System.out.println("2.- Febrero");
                System.out.println("3.- Marzo");
                System.out.println("4.- Abril");
                System.out.println("5.- Mayo");
                System.out.println("6.- Junio");
                System.out.println("7.- Julio");
                System.out.println("8.- Agosto");
                System.out.println("9.- Septiembre");
                System.out.println("10.- Agosto");
                System.out.println("11.- Noviembre");
                System.out.println("12.- Diciembre");
            }
            private static boolean esBisiesto(int ano){
                boolean bisiesto=false;
                int mod4=ano%4;
                int mod100=ano%100;
                int mod400=ano%400;
                if ((mod4==0)&&((!(mod100==0))||(mod400==0))){
                    bisiesto=true;
                }
                return bisiesto;
            }
            public static List<Nota> ordenarNotasBurbujaFecha(List<Nota>listaNotas){
                if((listaNotas!=null)&&(listaNotas.size()>=2)){
                    int nNotas=listaNotas.size();
                    for(int i=1;i<nNotas;i++){
                        int max=nNotas-i;
                        for(int j=0;j<max;j++){
                            Nota notaJ=listaNotas.get(j);
                            Nota notaJ1=listaNotas.get(j+1);
                            Calendar fechaJ=notaJ.getFecha();
                            Calendar fechaJ1=notaJ1.getFecha();
                            int comp=fechaJ.compareTo(fechaJ1);
                            if (comp>0){
                                listaNotas.set(j,notaJ1);
                                listaNotas.set(j+1,notaJ);
                            }
                        }
                    }
                }
                return listaNotas;
            }
}
