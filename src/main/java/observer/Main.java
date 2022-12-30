package observer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GroupAdmin manager = new GroupAdmin();
        ConcreteMember employee = new ConcreteMember();

        manager.register(employee);

//        Scanner sc = new Scanner(System.in);
//
//        while (!sc.next().equals("175"))





        employee.watchAllUpdates();

        System.out.println(employee.readCurrentContent());

        manager.unregister(employee);

        employee.watchUpdate();

        employee.watchAllUpdates();



    }
}
