package femmehack;
import java.util.*;

public class Channel {
    static int userID = 1;
    static int taskID = 1;
    static HashMap<Integer,User> userList=new HashMap<Integer,User>();
    static HashMap<Integer,Task> taskList=new HashMap<Integer,Task>();
    
    static void makeUser(String name, String email) {
        User user = new User(name, userID++, email);
        userList.add(user.getID(), user):
    }
    
    static void makeTask(User owner,String request, int time) {
        Task task = new Task(owner, request, time, taskID++);
        userList.add(user.getID(), user):
    }
    
    static void removeTask(int id) {
        taskList.remove(id);
    }
    
    
    
    
}
