import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    GroupAdmin sender = new GroupAdmin();
    ConcreteMember member1 = new ConcreteMember();
    ConcreteMember member2 = new ConcreteMember();


    @Test
    void readCurrentContent() {
        sender.append("this is test message");
        sender.register(member1);
        member1.readCurrentContent();
        assertEquals(member1.readCurrentContent() , "this is test message");
        assertEquals(member2.readCurrentContent() , "this is test message");
    }

    @Test
    void watchFirstUpdate() {
        sender.append("this is test message");
        sender.register(member1);
        sender.register(member2);
        sender.append(" and this is an extra");
        member1.watchFirstUpdate();
        sender.append(" this is extra extra");
        member2.watchFirstUpdate();
        member2.watchFirstUpdate();

    }

    @Test
    void watchAllUpdates() {
        sender.append("1");
        sender.register(member1);
        sender.register(member2);
        sender.append(" 2");
        sender.append(" 3");
        member1.watchAllUpdates();
        sender.append(" 4");
        member2.watchAllUpdates();
        member1.watchAllUpdates();
    }

}