package ejecutorpelicula;


import java.util.Arrays;
import java.util.ArrayList;

public class EjecutorPelicula {

    public static void main(String[] args) {
        dvd soporteDvd = new dvd(4.5);
        vhs soporteVhs = new vhs("Cinta Estandar");
        Soporte objSoporte = new Soporte();
        ArrayList<Pelicula> ListaPeliculas = new ArrayList<Pelicula>(Arrays.asList(
                new Pelicula("Intesamente", "Ricardo", "2024", "espanol", objSoporte),
                new Pelicula("JuegoTronos", "Daniel", "2000", "espanol", objSoporte),
                new Pelicula("Matriz", "Steven", "2024", "espanol", objSoporte)));
        for(Pelicula peli: ListaPeliculas){
            System.out.println(peli);
        }
    
    }
}

class Pelicula {

    public String Titulo;
    public String autor;
    public String anioEdicion;
    public String idioma;
    public double costoAlquiler;
    public Soporte soporte;

    public Pelicula(String Titulo, String autor, String anioEdicion, String idioma, Soporte soporte) {
        this.Titulo = Titulo;
        this.autor = autor;
        this.anioEdicion = anioEdicion;
        this.idioma = idioma;
        this.soporte = soporte;
    }
    public void calcularCostoALquiler() {
        
    }

    @Override
    public String toString() {
        return "Pelicula{" + "Titulo=" + Titulo + ", autor=" + autor + ", anioEdicion=" + anioEdicion + ", idioma=" + idioma + ", costoAlquiler=" + costoAlquiler + ", soporte=" + soporte + '}';
    }

}

class Soporte {
}

class dvd extends Soporte {
    public double capacidad;

    public dvd(double capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "dvd{" + "capacidad=" + capacidad + '}';
    }
    
}

class vhs extends Soporte {
     public String tipoCintaMag ;

    public vhs(String tipoCintaMag) {
        this.tipoCintaMag = tipoCintaMag;
    }

    @Override
    public String toString() {
        return "vhs{" + "tipoCintaMag=" + tipoCintaMag + '}';
    }

     
}
