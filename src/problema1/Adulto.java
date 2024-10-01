package problema1;

public class Adulto extends Thread {
    private final Puente puente;
    private final int id;
    private final int x;

    public Adulto(Puente puente, int identificador, int x) {
        this.puente = puente;
        this.id = identificador;
        this.x = x;
    }

    @Override
    public void run() {
        puente.quieroCruzar(true);
        System.out.println("Entra adulto " + id + ".....");
        try {
            sleep(x * 1000);
        } catch (InterruptedException e) {
        }
        System.out.println(".....Sale adulto " + id);
        puente.yaLlegue(true);
    }
}
