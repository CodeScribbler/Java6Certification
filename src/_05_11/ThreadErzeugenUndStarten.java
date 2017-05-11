package _05_11;


public class ThreadErzeugenUndStarten {

    // Inner

    class KochThread extends Thread {
        @Override
        public void run() {
            System.out.println("KochThread");
        }
    }

    class TelefonistThread extends Thread {
        @Override
        public void run() {
            System.out.println("TelefonistThread");
        }
    }

    class LieferantThread extends Thread {
        @Override
        public void run() {
            System.out.println("LieferantThread");
        }
    }


    // Nested

    static class KochThread2 extends Thread {
        @Override
        public void run() {
            System.out.println("KochThread");
        }
    }

    static class TelefonistThread2 extends Thread {
        @Override
        public void run() {
            System.out.println("TelefonistThread");
        }
    }

    static class LieferantThread2 extends Thread {
        @Override
        public void run() {
            System.out.println("LieferantThread");
        }
    }


    public static void main(String[] args) {

        new ThreadErzeugenUndStarten().new KochThread().start();
        new ThreadErzeugenUndStarten().new TelefonistThread().start();
        new ThreadErzeugenUndStarten().new LieferantThread().start();


        new ThreadErzeugenUndStarten.KochThread2().start();
        new ThreadErzeugenUndStarten.TelefonistThread2().start();
        new ThreadErzeugenUndStarten.LieferantThread2().start();


        // Anonym

        new Thread("Koch") {
            public void run() {
                System.out.println("Thread-Koch");
            }
        }.start();

        new Thread("Telefonist") {
            public void run() {
                System.out.println("Thread-Telefonist");
            }
        }.start();

        new Thread("Lieferant") {
            public void run() {
                System.out.println("Thread-Lieferant");
            }
        }.start();
    }

}


class KochThread extends Thread {
    @Override
    public void run() {
        System.out.println("KochThread");
    }
}


class TelefonistThread extends Thread {
    @Override
    public void run() {
        System.out.println("TelefonistThread");
    }
}


class LieferantThread extends Thread {
    @Override
    public void run() {
        System.out.println("LieferantThread");
    }
}