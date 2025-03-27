package session;

import java.util.HashSet;
import java.util.Set;

public class SessionSet {
    private Set<Session> set;
    private static SessionSet instance = new SessionSet();

    private SessionSet() {
        set = new HashSet<>();
    }

    public static SessionSet getInstance() {
        return instance;
    }

    public void add(Session session) {
        set.add(session);
    }

    public void remove(Session session) {
        set.remove(session);
    }

    public Set<Session> getSet() {
        return set;
    }
}