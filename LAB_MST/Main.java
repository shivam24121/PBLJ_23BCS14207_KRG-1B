// ques 1

import java.util.*;
class EmptyListException extends Exception {
    public EmptyListException(String msg) {
        super(msg);
    }
}
class StudentList {
    private ArrayList<String> list = new ArrayList<>();
    public void add(String name) {
        list.add(name);
    }
    public void remove(String name) {
        list.remove(name);
    }
    public void display() throws EmptyListException {
        if(list.isEmpty()) throw new EmptyListException("Student list is empty!");
        Collections.sort(list);
        System.out.println(list);
    }
}
public class Main {
    public static void main(String[] args) {
        StudentList sl = new StudentList();
        sl.add("Alice");
        sl.add("Bob");
        sl.add("Charlie");
        try {
            System.out.print("Sorted names: ");
            sl.display();
        } catch(Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
        System.out.println("Removing Bob...");
        sl.remove("Bob");
        try {
            System.out.print("Sorted names after removal: ");
            sl.display();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Attempting to display empty list...");
        sl.remove("Alice");
        sl.remove("Charlie");
        try {
            sl.display();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//ques 2

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("Enter numbers (type 'done' to finish):");
        while(true) {
            String input = sc.next();
            if(input.equalsIgnoreCase("done")) break;
            try {
                nums.add(Integer.parseInt(input));
            } catch(NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }
        try {
            if(nums.isEmpty()) throw new ArithmeticException("Cannot calculate average of empty list");
            double sum = 0;
            for(int n : nums) sum += n;
            double avg = sum / nums.size();
            System.out.println("Average: " + avg);
        } catch(ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

