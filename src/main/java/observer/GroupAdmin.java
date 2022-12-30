package observer;


import java.util.LinkedList;
import java.util.List;

public final class GroupAdmin implements Sender{

    private final UndoableStringBuilder builder;
    private List<Member> memberList;

    public GroupAdmin (){
        this.builder = new UndoableStringBuilder();
        this.memberList = new LinkedList<>();
    }

    @Override
    public void register(Member obj) {
        ConcreteMember temp = (ConcreteMember)obj;
        temp.getRegister(this);
        memberList.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        ConcreteMember temp = (ConcreteMember)obj;
        temp.getUnRegister();
        memberList.remove(obj);
    }

    /*

     */

    private void notifyAllMembers () {
        for (Member m : memberList){
            m.update(getBuilder());
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
