package observer;


import java.util.LinkedList;
import java.util.List;

/**
 * this class represent an Observer object that notify all the Members (Observables) about any change in the
 * UndoableStringBuilder object
 */

public final class GroupAdmin implements Sender{

    private final UndoableStringBuilder builder;
    private List<Member> memberList;

    public GroupAdmin (){
        this.builder = new UndoableStringBuilder();
        this.memberList = new LinkedList<>();
    }

    /**
        add a Member object into the Memberlist
        @param obj - object that implement Member interface (Observable pattern)
     */

    @Override
    public void register(Member obj) {
        ConcreteMember temp = (ConcreteMember)obj;
        temp.getRegister(this);
        memberList.add(obj);
    }

    /**
     * remove a Member from the Memberlist
     * @param obj - receive the address of the object we want to remove
     */
    @Override
    public void unregister(Member obj) {
        ConcreteMember temp = (ConcreteMember)obj;
        temp.getUnRegister();
        memberList.remove(obj);
    }

    /**
     * notify all the Members that register to this object about any change in the builder object
     * (pass on all the members and activate the @Update function)
     */

    public void notifyAllMembers () {
        if (!(memberList.isEmpty())) {
            for (Member m : memberList) {
                m.update(getBuilder());
            }
        }
    }

    @Override
    public void insert(int offset, String str) {
        builder.insert(offset,str);
        notifyAllMembers ();
    }

    @Override
    public void append(String str) {
        builder.append(str);
        notifyAllMembers ();
    }

    @Override
    public void delete(int start, int end) {
        builder.delete(start, end);
        notifyAllMembers ();
    }

    @Override
    public void undo() {
        builder.undo();
        notifyAllMembers ();
    }

    public UndoableStringBuilder getBuilder(){
        return this.builder;
    }

    public String toString () {
        return builder.toString();
    }
}
