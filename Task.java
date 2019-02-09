package femmehack;

public class Task {
    int id;
    int time;
    User owner;
    User doer;
    boolean owenerConfirm;
    boolean doerConfirm;
    boolean isConfirmed() {
        return owenerConfirm && doerConfirm;
    }

}
