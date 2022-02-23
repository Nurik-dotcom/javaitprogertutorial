/** work with Thread. This is example how works loading page in game */
import java.util.*;
class MyThread extends Thread{
    public void run() {
		for(int i = 1; i <= 10; i++)

			System.out.println(i);	
		}

    }
public class week5 {
    public static void main(String[] args) {
        MyThread c = new MyThread();
        ArrayList<String> b = new ArrayList<>(0);
        String a = "-";
        c.start();
        do {
            b.add(a);
            System.out.println(b);
        } while (b.size() <= 10);
    }
}
