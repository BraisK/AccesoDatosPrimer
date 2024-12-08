//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SaldoNegativoException {
        Cuenta cuenta1 = new Cuenta(1000, "Brais", "er", 0);
        Cuenta cuenta2 = new Cuenta(2000, "Afaf", "wef", 0);
        try {
            cuenta1.ingreso(100);
            cuenta2.retirada(200);
            cuenta1.transferir(cuenta2, 300);

        } catch (SaldoNegativoException e) {
            e.printStackTrace();
        }
        System.out.println(cuenta1);
        System.out.println(cuenta2);

        try {
            cuenta1.transferir(cuenta2, 200000);
        } catch (SaldoNegativoException e) {
            System.out.println("Saldo insuficiente para transferir");
        }
        try {
            cuenta1.retirada(50000);
        } catch (SaldoNegativoException e) {
            throw new SaldoNegativoException("A donde vas");
        }
    }

}