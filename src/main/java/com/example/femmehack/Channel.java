package com.example.femmehack;

import java.util.*;

public class Channel {
    static int userID = 0;
    static int taskID = 0;
    static HashMap<Integer, User> userList = new HashMap<Integer, User>(); // ID to user
    static HashMap<String, User> signIn = new HashMap<String, User>(); // email to user
    static HashMap<Integer, Task> taskList = new HashMap<Integer, Task>(); // ID to task

    // matches email, if email exists, tries to sign in by matching username
    // if not, makes new user with email
    static User signIn(String name, String email) {
        if (signIn.containsKey(email)) {
            User curr = signIn.get(email);
            if (curr.name.equals(name)) {
                return curr;
            } else {
                return null;
            }
        } else {

            User curr = makeUser(name, email);
            return curr;
        }
    }

    static User makeUser(String name, String email) {
        User user = new User(name, userID++, email);
        userList.put(user.id, user);
        signIn.put(email, user);
        return user;
    }

    static int makeTask(User owner, String request, int time) {
        taskID++;
        int newid = taskID;
        Task task = new Task(owner, request, time, newid);
        taskList.put(newid, task);
        return newid;
    }

    static void removeTask(int id) {
        taskList.remove(id);
    }

    static User getUser(int id) {
        return (User) userList.get(id);
    }

}
