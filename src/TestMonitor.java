import java.util.Random;
import problema1.Adulto;
import problema1.NoAdulto;
import problema1.Puente;

public class TestMonitor {
    public static void main(String[] args) {
        Random numAleatorio = new Random(101);
        Puente puente = new Puente();
        int num;
        for (int i = 1; i <= 10; i++) {
            num = numAleatorio.nextInt(101);
            if ((num % 2) == 0) { // si es par genera adulto
                Adulto adulto = new Adulto(puente, i, 2);
                adulto.start();
            } else { // si es impar genera niño
                NoAdulto noAdulto = new NoAdulto(puente, i, 3);
                noAdulto.start();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
