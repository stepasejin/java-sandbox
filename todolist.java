import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "[" + (isCompleted ? "X" : " ") + "] " + description;
    }
}

public class ToDoListManager {

    private ArrayList<Task> tasks;
    private Scanner scanner;

    public ToDoListManager() {
        this.tasks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            executeUserChoice(choice);
        } while (choice != 0);
    }

    private void displayMenu() {
        System.out.println("\n===== To-Do List Manager =====");
        System.out.println("1. Add a task");
        System.out.println("2. Show tasks");
        System.out.println("3. Mark a task as completed");
        System.out.println("0. Exit");
    }

    private int getUserChoice() {
        System.out.print("Enter the action number: ");
        return scanner.nextInt();
    }

    private void executeUserChoice(int choice) {
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                showTasks();
                break;
            case 3:
                markTaskAsCompleted();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addTask() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added.");
    }

    private void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("The task list is empty.");
        } else {
            System.out.println("===== Task List =====");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void markTaskAsCompleted() {
        showTasks();
        System.out.print("Enter the task number you want to mark as completed: ");
        int taskNumber = scanner.nextInt();
        if (isValidTaskNumber(taskNumber)) {
            tasks.get(taskNumber - 1).markAsCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private boolean isValidTaskNumber(int taskNumber) {
        return taskNumber > 0 && taskNumber <= tasks.size();
    }

    public static void main(String[] args) {
        ToDoListManager toDoListManager = new ToDoListManager();
        toDoListManager.run();
    }
}
