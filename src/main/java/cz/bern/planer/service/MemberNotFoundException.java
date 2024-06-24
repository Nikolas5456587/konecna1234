package cz.bern.planer.service;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(long id) {
        super("Member with ID " + id + " not found");
    }

    public MemberNotFoundException(String username) {
        super("Member with username " + username + " not found");
    }
}
