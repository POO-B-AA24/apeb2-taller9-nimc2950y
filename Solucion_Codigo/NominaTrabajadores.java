package nominatrabajadores;

public class NominaTrabajadores {
    public static void main(String[] args) {
        TrabajoFijoMensual trabajadorFijo = new TrabajoFijoMensual("Nathan", "Moreno", "Ramon pinto", "1106789456", 450);
        Comisionistas trabajadorComisionista = new Comisionistas("Kevin", "Moreira", "Simon Bolivar", "1103478903", 0.10);
        HorasTrabajadas trabajadorHoras = new HorasTrabajadas("Mario", "López", "Jose Antonio Enguiren", "1105576233", 10);
        Jefe jefe = new Jefe("Jorge", "Alvarez", "Yahuarcuna", "1105578932", 850);
        
        
    }
}
class Trabajador {
    public String nombre;
    public String apellido;
    public String direccion;
    public String dni;

    public Trabajador(String nombre, String apellido, String direccion, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
    }
    
    public String calcularSueldo() {
        return "";
    }

    public String imprimirNomina() {
        return "";
    }
    
    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + '}';
    }
    
}

class TrabajoFijoMensual extends Trabajador {
    public double sueldoMensual;

    public TrabajoFijoMensual(String nombre, String apellido, String direccion, String dni, double sueldoMensual) {
        super(nombre, apellido, direccion, dni);
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public String calcularSueldo() {
        return "Sueldo mensual de " + nombre + " " + apellido + ": " + sueldoMensual;
    }

    @Override
    public String imprimirNomina() {
        return "Nómina de " + nombre + " " + apellido + ": " + sueldoMensual;
    }

    @Override
    public String toString() {
        return "TrabajoFijoMensual{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + ", sueldoMensual=" + sueldoMensual + '}';
    }
}

class HorasTrabajadas extends Trabajador {
    public float precioHoras;
    public int horas;
    public float horasExtras;

    public HorasTrabajadas(String nombre, String apellido, String direccion, String dni, float precioHoras) {
        super(nombre, apellido, direccion, dni);
        this.precioHoras = precioHoras;
        this.horas = 0;
        this.horasExtras = 0;
    }

    public void registrarHoras(int horas) {
        if (this.horas + horas > 40) {
            this.horasExtras += (this.horas + horas - 40);
            this.horas = 40;
        } else {
            this.horas += horas;
        }
    }

    @Override
    public String calcularSueldo() {
        double sueldo = (horas * precioHoras) + (horasExtras * precioHoras * 1.5);
        return "Sueldo de " + nombre + " " + apellido + ": " + sueldo;
    }

    @Override
    public String imprimirNomina() {
        double sueldo = (horas * precioHoras) + (horasExtras * precioHoras * 1.5);
        return "Nómina de " + nombre + " " + apellido + ": " + sueldo;
    }

    @Override
    public String toString() {
        return "HorasTrabajadas{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + ", precioHoras=" + precioHoras + ", horas=" + horas + ", horasExtras=" + horasExtras + '}';
    }
}

class Comisionistas extends Trabajador {
    public double porcentaje;
    public double ventas;

    public Comisionistas(String nombre, String apellido, String direccion, String dni, double porcentaje) {
        super(nombre, apellido, direccion, dni);
        this.porcentaje = porcentaje;
        this.ventas = 0;
    }

    public void registrarVentas(double ventas) {
        this.ventas += ventas;
    }

    @Override
    public String calcularSueldo() {
        double sueldo = ventas * porcentaje;
        return "Sueldo de " + nombre + " " + apellido + ": " + sueldo;
    }

    @Override
    public String imprimirNomina() {
        double sueldo = ventas * porcentaje;
        return "Nómina de " + nombre + " " + apellido + ": " + sueldo;
    }

    @Override
    public String toString() {
        return "Comisionistas{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + ", porcentaje=" + porcentaje + ", ventas=" + ventas + '}';
    }
}

class Jefe extends Trabajador {
    public double sueldoFijo;

    public Jefe(String nombre, String apellido, String direccion, String dni, double sueldoFijo) {
        super(nombre, apellido, direccion, dni);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public String calcularSueldo() {
        return "Sueldo de " + nombre + " " + apellido + ": " + sueldoFijo;
    }

    @Override
    public String imprimirNomina() {
        return "Nómina de " + nombre + " " + apellido + ": " + sueldoFijo;
    }

    @Override
    public String toString() {
        return "Jefe{" + "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + ", sueldoFijo=" + sueldoFijo + '}';
    }
}