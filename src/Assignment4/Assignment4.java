package Assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assignment4 extends Thread {
    static List<Item> itemlist = new ArrayList<Item>();

    public Assignment4(List<Item> itemlist) {
        this.itemlist = itemlist;
    }

    @Override
    public void run() {
        synchronized (itemlist) {
            try {
                itemlist = ConnectionConfiguration.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        itemlist = Collections.synchronizedList(new ArrayList<Item>());

        //Creation of first thread to read item details from database
        Assignment4 thread1 = new Assignment4(itemlist);
        thread1.start();

        //second thread will wait for first thread to complete its execution and terminate
        thread1.join();

        //Creation of second thread to display the details
        SecondThread thread2 = new SecondThread(itemlist);
        thread2.start();
    }

}