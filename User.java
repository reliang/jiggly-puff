import java.util.ArrayList;

public class User {
	String name; //username, case-sensitive, make unique??
	int id;
	int credit;
	String email;
	ArrayList<Integer> myTasks; //request to others
	ArrayList<Integer> toDo; //requests we've taken
	
	public User(String name, int id, String email) {
		this.name = name;
		this.id = id;
		this.email = email;
		credit = 2;
		myTasks = new ArrayList<Integer>();
		toDo = new ArrayList<Integer>();
	}
	
	boolean addRequest(String request, int time) {
		if (time > credit) {
			return false;
		}
		int task = Channel.makeTask(this, request, time);
		myTasks.add(task);
		return true;
	}
	
	void deleteMyTask(int task) {
		myTasks.remove((Integer) task);
	}
	
	void deleteToDo(int task) {
		toDo.remove((Integer) task);
	}
	
	//confirm items from toDo
	void confirmIdid(int task) {
		Task t = Channel.taskList.get(task);
		t.doerConfirm = true;
		t.isConfirmed();
	}
	
	//confirm items from myTasks
	void confirmTheydid(int task) {
		Task t = Channel.taskList.get(task);
		t.ownerConfirm = true;
		t.isConfirmed();
	}
	//check to make sure task is available?
	void takeTask(int task) {
		Task t = Channel.taskList.get(task);
		if (t != null) {
			t.doer = this;
			t.taken = true;
			this.toDo.add(task);
		}
	}
}
