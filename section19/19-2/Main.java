import java.util.*;

class PrintingThread extends Thread {
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("なにか入力してください");
        Thread t = new PrintingThread();
        t.start();
        new Scanner(System.in).nextLine();
    }
}
