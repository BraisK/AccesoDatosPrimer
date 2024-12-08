/**
 * Escribe una clase Cuenta para representar una cuenta bancaria. Los datos de la
 * cuenta son: nombre del cliente (String), número de cuenta (String), tipo de interés
 * (double) y saldo (double), no deben de ser accesibles desde otras clases, todos los
 * métodos deben hacer uso de excepciones para manejar posibles condiciones de
 * error a la hora de manejar importes, se pide el uso de al menos la creación de una
 * clase de excepción personalizada, las excepciones controlarán que los importes
 * sean correctos y una cuenta no pueda quedar en números rojos.
 * La clase contendrá los siguientes métodos:
 * § Constructor por defecto
 * § Constructor con todos los parámetros
 * § Métodos setters/getters para asignar y obtener los datos de la cuenta.
 * § Métodos ingreso y reintegro. Un ingreso consiste en aumentar el saldo en la
 * cantidad que se indique. Esa cantidad no puede ser negativa. Un reintegro
 * consiste en disminuir el saldo en una cantidad, pero antes se debe comprobar
 * que hay saldo suficiente. La cantidad no puede ser negativa. Los métodos
 * ingreso y reintegro devuelven true si la operación se ha podido realizar o false en
 * caso contrario.
 * § Método transferencia que permita pasar dinero de una cuenta a otra siempre
 * que en la cuenta de origen haya dinero suficiente para poder hacerla. Ejemplo
 * de uso del método transferencia:
 * cuentaOrigen.transferencia(cuentaDestino, importe);
 * que indica que queremos hacer una transferencia desde cuentaOrigen
 * cuentaDestino del importe indicado.
 */
public class Cuenta {
    private String nombreCliente;
    private String numeroCuenta;
    private double interes;
    private double saldo;

    public Cuenta() {
    }

    public void ingreso(double cantidad) {
        if (cantidad <= 0) {
            throw  new IllegalArgumentException("Ingrese una cantidad mayor que 0");
        }
        saldo += cantidad;
    }
    public void retirada(double cantidad) throws SaldoNegativoException {
        if (cantidad <= 0) {
            throw  new IllegalArgumentException("Ingrese una cantidad mayor que 0");
        } if (cantidad > this.saldo) {
            throw new SaldoNegativoException("Saldo insuficiente");
        }
        saldo -= cantidad;
    }
    public void transferir(Cuenta cuentaDestino, double cantidad) throws SaldoNegativoException {
        if (cantidad > this.saldo){
            throw  new SaldoNegativoException("Saldo insuficiente");
        }
        cuentaDestino.saldo += cantidad;
    }

    public Cuenta(double saldo, String nombreCliente, String numeroCuenta, double interes) {
        this.saldo = saldo;
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.interes = interes;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        if (interes <= 0) {
            throw  new IllegalArgumentException("Ingrese un interes mayor que 0");
        }
        this.interes = interes;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo <= 0) {
            throw  new IllegalArgumentException("Saldo mayor que 0");
        }
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", interes=" + interes +
                ", saldo=" + saldo +
                '}';
    }
}
