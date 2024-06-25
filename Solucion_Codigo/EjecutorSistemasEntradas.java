package ejecutorsistemasentradas;

public class EjecutorSistemasEntradas {
    public static void main(String[] args) {
        Zona principal = new Zona("Principal", 200, 25, 17.5);
        Zona palcoB = new Zona("PalcoB", 40, 70, 40);
        Zona central = new Zona("Central", 400, 20, 14);
        Zona lateral = new Zona("Lateral", 100, 15.5, 10);

        Entrada entrada1 = new EntradaNormal(principal, 1, "Steven Benavides");
        Entrada entrada2 = new EntradaReducida(palcoB, 2, "Emilio  pena");
        Entrada entrada3 = new EntradaAbonada(central, 3, "Nathan Moreno");

        entrada1.mostrarInfo();
        entrada2.mostrarInfo();
        entrada3.mostrarInfo();
    }
}

class Zona {
    public String nombre;
    public int numeroLocalidades;
    public double precioNormal;
    public double precioAbonado;

    public Zona(String nombre, int numeroLocalidades, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.numeroLocalidades = numeroLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioAbonado() {
        return precioAbonado;
    }
}

abstract class Entrada {
    public Zona zona;
    public int id;
    public String nombComprador;
    public double precio;

    public Entrada(Zona zona, int id, String nombComprador) {
        this.zona = zona;
        this.id = id;
        this.nombComprador = nombComprador;
        this.precio = calcularPrecioEntrada();
    }

    public abstract double calcularPrecioEntrada();

    public void mostrarInfo() {
        System.out.println("ID: " + id + ", Comprador: " + nombComprador + ", Zona: " + zona.getNombre() + ", Precio: $" + precio);
    }
}

class EntradaNormal extends Entrada {
    public EntradaNormal(Zona zona, int id, String nombComprador) {
        super(zona, id, nombComprador);
    }

    @Override
    public double calcularPrecioEntrada() {
        return zona.getPrecioNormal();
    }
}

class EntradaReducida extends Entrada {
    public EntradaReducida(Zona zona, int id, String nombComprador) {
        super(zona, id, nombComprador);
    }

    @Override
    public double calcularPrecioEntrada() {
        return zona.getPrecioNormal() * 0.8; // 20% discount
    }
}

class EntradaAbonada extends Entrada {
    public EntradaAbonada(Zona zona, int id, String nombComprador) {
        super(zona, id, nombComprador);
    }

    @Override
    public double calcularPrecioEntrada() {
        return zona.getPrecioAbonado();
    }
}
