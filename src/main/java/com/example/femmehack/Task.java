package com.example.femmehack;

public class Task {
    String name;
    int id;
    int time;
    User owner;
    User doer;
    boolean taken;
    boolean ownerConfirm;
    boolean doerConfirm;
    
    public Task(User owner, String request, int time, int id) {
    name = request;
        this.id = id;
        this.owner = owner;
        this.time = time;
        taken = false;
        ownerConfirm = false;
        doerConfirm = false;
    }
    
    void isConfirmed() {
        if (ownerConfirm && doerConfirm) {
            Channel.removeTask(id);
            owner.deleteMyTask(id);
            doer.deleteToDo(id);
            owner.credit -= time;
            doer.credit += time;
        };
    }
}