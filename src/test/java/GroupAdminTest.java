import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    GroupAdmin sender = new GroupAdmin();
    ConcreteMember member1 = new ConcreteMember();
    ConcreteMember member2 = new ConcreteMember();

    @Test
    void register() {
        sender.register(member1);
        sender.register(member2);
    }

    @Test
    void unregister() {
        sender.unregister(member1);
        sender.unregister(member2);
        sender.unregister(null);
    }

    @Test
    void notifyAllMembers() {
        sender.register(member1);
        sender.register(member2);
        sender.append("first massage");
    }
    @Test
    void undo() {

        sender.register(member1);
        sender.register(member2);
        sender.append("firstmassage");
        sender.delete(0 , Integer.MAX_VALUE);
        sender.undo();

        assertAll(
                () -> assertTrue(member1.readCurrentContent().equals("firstmassage")),
                () -> assertTrue(member2.readCurrentContent().equals("firstmassage"))
        );


    }

}