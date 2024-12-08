package Ejercicios;

public class Ejercicio3Exceptions {

    public static void main(String[] args) {
        divide();
    }
    static void divide(){
        int num[]={4,8,16,32,64,128,256};
        int den[]={2,0,4,4,0,8,16};
        for (int i=0;i<num.length;i++){
            try{
                System.out.println(num[i]+ "/" + den[i]+"=" + num[i]/den[i]);}
            catch(java.lang.ArithmeticException excepcion){
                System.out.println("Dividiendo por 0");
            }
        }
    }
}
