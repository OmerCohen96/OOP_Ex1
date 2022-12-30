package observer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * this class implement the Observable pattern
 * any instance of this class that register to the main observer
 * get notify from the Observer about any change in the UndoableStringbuilder - the main object in the observer class
 */

public class ConcreteMember implements Member {

    private UndoableStringBuilder shallowBuilder;

    private int push;

    private boolean register;

    // this data member below save all the changes that have been made in the main observer,
    // until the user see all the updates when he use
    // @watchFirstUpdate and @watchalltUpdates functions


    private Queue<String> allUpdates;


    public ConcreteMember() {
        this.shallowBuilder = null;
        this.push = 0;
        this.register = false;
        this.allUpdates = new LinkedList<>();
    }

    /**
     * should be activated by the observer object,
     * when the observer object activate his @register function
     * this instance added to the observer Memberlist
     * this instance object receive the observer UndoableStringBuilder in a shallow copy
     *
     * @param sender - the observer Sender of this instance
     */

    public void getRegister(GroupAdmin sender) {
        if (!register) {

            shallowBuilder = sender.getBuilder();

            System.out.println("Glad you joined :)");

            this.register = true;

            return;
        }

        System.out.println("already register");
    }

    /**
     * should be activated by the observer object,
     * if the observer want to remove this instance from the Member list
     */

    public void getUnRegister() {
        if (register) {

            shallowBuilder = null;

            this.register = false;

            System.out.println("hope we see you again!");

            return;
        }

        System.out.println("not register to any sender");
    }

    /**
     * @return the UndoableStringBuilder data if this instance is register
     */

    public String readCurrentContent() {
        if (register) {
            return shallowBuilder.toString();
        }

        return null;
    }

    /**
     * should be activated by the observer
     * insert the latest update into our queue
     * @param usb - to read the current data from the stringbuilder
     */

    @Override
    public void update(UndoableStringBuilder usb) {
        ++push;

        allUpdates.add(usb.toString());

        System.out.println("you have " + push + " massages");
    }

    /**
     * read the first update that we didn't read yet
     */

    public void watchFirstUpdate() {
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

    /**
     * watch all the latest's updates we didn't read yet , in order, oldest to newest
     */

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

        return "you don't register to any Sender 2";
    }
}
