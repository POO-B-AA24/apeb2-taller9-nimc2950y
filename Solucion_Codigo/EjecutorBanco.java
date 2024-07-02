package ejecutorbanco;

public class EjecutorBanco {

    public static void main(String[] args) {
        CuentaCheques cuentaCheques = new CuentaCheques("35678904", "Nathan Moreno");
        CuentaAhorros cuentaAhorros = new CuentaAhorros("11089234", "Nathan Moreno", 0.02);
        CuentaPlatino cuentaPlatino = new CuentaPlatino("78933435", "Nathan Moreno");

        cuentaCheques.depositar(500);
        cuentaCheques.retirar(200);
        cuentaAhorros.depositar(1000);
        cuentaAhorros.calcularInteres();
        cuentaAhorros.retirar(500);
        cuentaPlatino.depositar(2000);
        cuentaPlatino.calcularInteres();
        cuentaPlatino.retirar(2500);
        System.out.println(cuentaCheques);
        System.out.println(cuentaAhorros);
        System.out.println(cuentaPlatino);
    }

}

class CuentaBancaria {

    private String numeroCuenta;
    private String nombreCliente;
    protected double balance;

    public CuentaBancaria(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0.0;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            balance += cantidad;
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            balance -= cantidad;
        }
    }

    public double obtenerBalance() {
        return balance;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{"
                + "numeroCuenta='" + numeroCuenta + '\''
                + ", nombreCliente='" + nombreCliente + '\''
                + ", balance=" + balance
                + '}';
    }
}

class CuentaCheques extends CuentaBancaria {

    public CuentaCheques(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    @Override
    public String toString() {
        return "CuentaCheques{"
                + "numeroCuenta='" + getNumeroCuenta() + '\''
                + ", nombreCliente='" + getNombreCliente() + '\''
                + ", balance=" + obtenerBalance()
                + '}';
    }
}

class CuentaAhorros extends CuentaBancaria {

    private double tasaInteres;

    public CuentaAhorros(String numeroCuenta, String nombreCliente, double tasaInteres) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0 && obtenerBalance() >= cantidad) {
            super.retirar(cantidad);
        }
    }

    public void calcularInteres() {
        depositar(obtenerBalance() * tasaInteres);
    }

    @Override
    public String toString() {
        return "CuentaAhorros{"
                + "numeroCuenta='" + getNumeroCuenta() + '\''
                + ", nombreCliente='" + getNombreCliente() + '\''
                + ", balance=" + obtenerBalance()
                + ", tasaInteres=" + tasaInteres
                + '}';
    }
}

class CuentaPlatino extends CuentaBancaria {

    private final double tasaInteres = 0.10;

    public CuentaPlatino(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    public void calcularInteres() {
        depositar(obtenerBalance() * tasaInteres);
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            super.retirar(cantidad);
        }
    }

    @Override
    public String toString() {
        return "CuentaPlatino{"
                + "numeroCuenta='" + getNumeroCuenta() + '\''
                + ", nombreCliente='" + getNombreCliente() + '\''
                + ", balance=" + obtenerBalance()
                + ", tasaInteres=" + tasaInteres
                + '}';
    }
}
