public class TrojkatRownoramienny {

    double podstawa;
    double ramie;

    public TrojkatRownoramienny(double podstawa, double ramie) {
        this.podstawa = podstawa;
        this.ramie = ramie;

    }

    public TrojkatRownoramienny() {

    }

    public double wysokosc(double ramie) {
        double height = ramie / 2;
        return height;
    }

    public double wysokosc() {
        return 0;
    }
}
