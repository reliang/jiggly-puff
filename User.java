import java.util.ArrayList;

public class User {
	String name;
	int id;
	int credit;
	String email;
	ArrayList<Integer> myTasks;
	ArrayList<Integer> toDo;
	
	public User(String name, int id, String email) {
		this.name = name;
		this.id = id;
		this.email = email;
		credit = 0;
		myTasks = new ArrayList<Integer>();
		toDo = new ArrayList<Integer>();
	}
	
	void addRequest(String request, int time) {
		int task = Channel.makeTask(this, request, time);
		myTasks.add(task);
	}
	
	void deleteTask(int task) {
		myTasks.remove((Integer) task);
	}
	
	void confirmIdid(int task) {
		Task t = Channel.taskList.get(task);
		t.userConfirm = true;
		t.isConfirmed();
	}
	
	void confirmTheydid(int task) {
		Task t = Channel.taskList.get(task);
		t.ownerConfirm = true;
		t.isConfirmed();
	}
	
	void takeTask(int task) {
		Task t = Channel.taskList.get(task);
		t.doer = this;
		t.taken = true;
		Channel.removeTask(task);
	}
}
