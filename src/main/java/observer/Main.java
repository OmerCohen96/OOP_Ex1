package observer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GroupAdmin manager = new GroupAdmin();
        ConcreteMember omer = new ConcreteMember();
        manager.register(omer);
        manager.append("firstmassage");
        manager.delete(0, Integer.MAX_VALUE);
        manager.undo();

        System.out.println(omer.readCurrentContent().equals("firstmassage"));







    }
}
