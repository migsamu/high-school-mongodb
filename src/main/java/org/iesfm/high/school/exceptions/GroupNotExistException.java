package org.iesfm.high.school.exceptions;

public class GroupNotExistException extends Exception {

    private int id;

    public GroupNotExistException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
