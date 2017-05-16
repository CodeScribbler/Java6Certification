package _05_16;

public class Exercise extends Thread {

    private final StringBuffer sb;

    public Exercise(StringBuffer character) {
        this.sb = character;
    }

    @Override
    public void run() {
        synchronized (sb) {
            for (int i = 1; i <= 100; i++) {
                System.err.print(sb);
            }
            System.err.println();

            char character = sb.charAt(0);
            sb.setCharAt(0, ++character);
        }
    }

    public static void main(String[] args) {k
        StringBuffer sb = new StringBuffer("A");

        new Exercise(sb).start();
        new Exercise(sb).start();
        new Exercise(sb).start();

    }
}