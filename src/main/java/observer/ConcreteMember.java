package observer;

import java.util.LinkedList;
import java.util.Queue;


public class ConcreteMember implements Member {

    private UndoableStringBuilder shallowBuilder;

    private int push;

    private boolean register;

    private Queue<String> allUpdates;

    public ConcreteMember() {
        this.shallowBuilder = null;
        this.push = 0;
        this.register = false;
        this.allUpdates = new LinkedList<>();
    }

    public void getRegister(GroupAdmin sender) {
        if (!register) {

            shallowBuilder = sender.getBuilder();

            System.out.println("Glad you joined :)");

            this.register = true;

            return;
        }

        System.out.println("already register");
    }

    public void getUnRegister() {
        if (register) {

            shallowBuilder = null;

            this.register = false;

            System.out.println("hope we see you again!");

            return;
        }

        System.out.println("not register to any sender");
    }

    public String readCurrentContent() {
        if (register) {
            return shallowBuilder.toString();
        }

        return null;
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        ++push;

        allUpdates.add(usb.toString());

        System.out.println("you have " + push + " massages");
    }

    public void watchUpdate() {
        if (register) {
            if (push > 0) {
                String s = allUpdates.poll();

                System.out.println(s);

                push--;

                return;
            }

            System.out.println("you don't have a new update");
            return;
        }
        System.out.println("you dont register to any Sender");
    }

    public void watchAllUpdates() {
        if (register) {
            if (push > 0) {
                while (!(allUpdates.isEmpty())) {
                    System.out.println(allUpdates.poll());
                }
                push = 0;
                return;
            }
            System.out.println("you don't have a new update 2");
            return;
        }
        System.out.println("you dont register to any Sender 2");
    }

    public boolean isRegister() {
        return register;
    }

    public String toString() {
        if (register) {
            return this.readCurrentContent() + "\n" +
                    "register \n" +
                    "there is " + push + " new updates";


        }

        return "you dont register to any Sender 2";
    }
}
