package org.iesfm.high.school.exceptions;

public class GroupAlreadyExistException extends Exception{
    private int id;

    public GroupAlreadyExistException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
