public class Kolo4 {

    public static class Buzka implements PrzedstawiaEmocje, Rysowalny {

        protected char x;

        public Buzka(char x) {
            this.x = x;
        }

        @Override
        public void draw() {
            System.out.println(":-" + x);
        }

        @Override
        public boolean czySieUsmiecha() {
            return false;
        }

        @Override
        public void przestanSieUsmiechac() {

        }
    }

    public static class Usmiech extends Buzka implements Skalowalny {

        public Usmiech(char x) {
            super(x);
        }

        public Usmiech() {
            super(')');
        }

        @Override
        public void draw(int times) {
            System.out.print(":-");
            for (int i = 0; i < times; i++) {
                System.out.print(x);
            }
            System.out.println();
        }


    }

    public interface PrzedstawiaEmocje {

        void draw();

        boolean czySieUsmiecha();

        void przestanSieUsmiechac();
    }

    public interface Rysowalny extends PrzedstawiaEmocje {

    }

    public interface Skalowalny extends PrzedstawiaEmocje, Rysowalny {

        void draw(int times);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // TODO Nie zmieniając main spraw aby program działał
        // TODO Stwórz klasy Buzka, Usmiech
        // TODO Stwórz interfejsy Ryswalny, Skalowalny, PrzedstawiaEmocje

        // TODO zadbaj o jakość kodu
        // TODO nie dubluj niepotrzebnie kodu, nie pisz niepotrzebnego kodu
        // TODO staraj się ogólną funkcjonalność umieścić jak najwyżej w drzewie
        // dziedziczenia


        Usmiech u1 = new Usmiech();
        Buzka u2 = new Buzka('(');

        Buzka t1 = new Usmiech();
        PrzedstawiaEmocje t2 = new Buzka('(');
        Rysowalny t3 = new Buzka('(');
        Skalowalny t4 = new Usmiech();

        Rysowalny u3 = new Usmiech();
        Rysowalny u4 = (Rysowalny) new Skalowalny() {

            @Override
            public void draw() {
                System.out.println(toString());
            }

            @Override
            public boolean czySieUsmiecha() {
                return false;
            }

            @Override
            public void przestanSieUsmiechac() {

            }

            @Override
            public void draw(int times) {
                System.out.print(toString());
                if (times > 1)
                    System.out.print(")".repeat(times - 1));
                System.out.println();
            }

            @Override
            public String toString() {
                return ":-)";
            }
        };
        PrzedstawiaEmocje u5 = new Buzka(')');

        System.out.println("Wydrukuj :-)");
        u4.draw(); // drukuje :-)
        System.out.println("Wydrukuj :-)))");
        ((Skalowalny) u4).draw(3); // drukuje :-)))
        System.out.println("Wydrukuj :-(");
        u2.draw(); // drukuje :-(
        System.out.println("Wydrukuj :-)))");
        u1.draw(3); // drukuje :-)))
        System.out.println("Wydrukuj :-(");
        ((Rysowalny) ((PrzedstawiaEmocje) u2)).draw(); // drukuje :-(
        System.out.println("Wydrukuj :-)");
        ((Rysowalny) ((PrzedstawiaEmocje) ((Buzka) u1))).draw(); // drukuje :-)

        if (("" + u1).equals(":-)"))
            System.out.println("OK 1");
        if (("" + u2).equals(":-("))
            System.out.println("OK 2");

        if (u1.toString().equals(u4.toString()))
            System.out.println("OK 3");
        if (u1.toString().equals(":-)"))
            System.out.println("OK 4");
        if (u5.toString().equals(":-)"))
            System.out.println("OK 5");

        if (u5.czySieUsmiecha())
            System.out.println("OK 6");
        if (u1.czySieUsmiecha())
            System.out.println("OK 7");
        if (!u2.czySieUsmiecha())
            System.out.println("OK 8");

        u5.przestanSieUsmiechac();
        if (!u5.czySieUsmiecha())
            System.out.println("OK 9");
        u1.przestanSieUsmiechac();
        if (u1.czySieUsmiecha())
            System.out.println("OK 10");

        if (u1.equals(u3))
            System.out.println("OK 11");
        if (u2.equals(u5))
            System.out.println("OK 12");
        if (!u1.equals(u5))
            System.out.println("OK 13");
        if (!u2.equals(u3))
            System.out.println("OK 14");
    }

}
