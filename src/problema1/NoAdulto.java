package problema1;

public class NoAdulto extends Thread {
    private final Puente puente;
    private final int id;
    private final int y;

    public NoAdulto(Puente puente, int identificador, int y) {
        this.puente = puente;
        this.id = identificador;
        this.y = y;
    }

    @Override
    public void run() {
        puente.quieroCruzar(false);
        System.out.println("Entra niño " + id + "......");
        try {
            sleep(y * 1000);
        } catch (InterruptedException e) {
        }
        System.out.println(".....Sale niño " + id);
        puente.yaLlegue(false);
    }
}
