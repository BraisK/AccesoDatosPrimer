public class SaldoNegativoException extends Exception{
    public SaldoNegativoException(){
        super();
    }
    public SaldoNegativoException(String message){
        super(message);
    }
    public SaldoNegativoException(String message, Throwable cause){
        super(message, cause);
    }
}
