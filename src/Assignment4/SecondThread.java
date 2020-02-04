package Assignment4;

import java.util.ArrayList;
import java.util.List;

class SecondThread extends Thread {
    static List<Item> itemlist = new ArrayList<Item>();

    public SecondThread(List<Item> itemlist) {

        this.itemlist = itemlist;
    }

    // second thread to display item details after calculating tax
    @Override
    public void run() {
        synchronized (itemlist) {
            for (int i = 0; i < itemlist.size(); i++) {
                if (itemlist.get(i).getPrice() != 0) {
                    itemlist.get(i).calculateTax();

                    System.out.println("Item " + (i + 1) + " details:");
                    System.out.println("Item name: " + itemlist.get(i).getName());
                    System.out.println("Item price: " + itemlist.get(i).getPrice());
                    System.out.println("Tax: " + itemlist.get(i).getTax());
                    System.out.println("Final price: " + (itemlist.get(i).getTax() + itemlist.get(i).getPrice()));
                    System.out.println("--------------------------------------------------------------");
                }
            }
        }
    }
}