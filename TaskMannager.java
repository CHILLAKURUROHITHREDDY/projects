import java.util.ArrayList;
import java.util.Scanner;

public class TaskMannager {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		TaskList list = new TaskList();
		
		boolean quite = true;
		while(quite) {
			
			System.out.println("Task List Application\n");
	        System.out.println("1. Add Task");
	        System.out.println("2. Remove Task");
	        System.out.println("3. List Tasks");
	        System.out.println("4. Quit");
	        System.out.print("Select an option: ");
	        
			switch(scan.nextInt()) {
				case 1:
					System.out.print("\nEnter task name: ");
					list.add(scan.next());
					break;
				case 2:
					if(list.size() != 0) {
						list.display();
						System.out.print("Enter the task number to remove: ");
						list.remove(scan.nextInt());						
					}
					else {
						System.out.println("\nNo tasks to remove.\n");
					}
					break;
				case 3:
					list.display();
					break;
				case 4:
					quite = false;
					break;
			}
		}
		scan.close();
	}
	

}

class TaskList	{
	
	private ArrayList<String> taskList = new ArrayList<>();
	
	public void add(String task) {
		taskList.add(task);
		System.out.println("Task added.\n");
	}
	public void remove(int index) {
		if(index <= size()) {
			taskList.remove(index-1);
			System.out.println("Task removed.\n");
		}
		else {
			System.out.println("\nInvalid task number.\n");
		}
		
	}
	public void display() {
		if(size() != 0) {
			System.out.println();
			for(int i=0; i<taskList.size(); i++) {
				System.out.println((i+1) + ". " + taskList.get(i));
			}
			System.out.println();
		}
		else {
			System.out.println("\nNo tasks to list.\n");
		}
	}
	public int size() {
		return taskList.size();
	}
}
