package problema1;

public class Puente {
    private int adultosCruzando, niñosCruzando;

    public Puente() {
        adultosCruzando = 0;
        niñosCruzando = 0;
    }

    public synchronized void quieroCruzar(boolean esAdulto) {
        if (esAdulto) {
            while ((niñosCruzando > 2) || (adultosCruzando == 1))
                try {
                    wait();
                } catch (InterruptedException ie) {
                }
            adultosCruzando++;
        } else {
            while ((niñosCruzando == 4) || ((adultosCruzando == 1) &&
                    (niñosCruzando == 2)))
                try {
                    wait();
                } catch (InterruptedException ie) {
                }
            niñosCruzando++;
        }
    }

    public synchronized void yaLlegue(boolean esAdulto) {
        if (esAdulto)
            adultosCruzando--;
        else
            niñosCruzando--;
        notifyAll();
    }
}
