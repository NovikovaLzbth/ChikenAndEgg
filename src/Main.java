public class Main {

    private static String result = "";

    public static void main(String[] args) {
        Thread chickenThread = new Thread(() -> {
            result = "Курица";
            System.out.println(result);
        });

        Thread eggThread = new Thread(() -> {
            result = "Яйцо";
            System.out.println(result);
        });

        chickenThread.start();
        eggThread.start();

        try {
            chickenThread.join(); //завершение потока курица
            eggThread.join();     //завершение потока яйцо
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Последнее слово: " + result);
    }
}
