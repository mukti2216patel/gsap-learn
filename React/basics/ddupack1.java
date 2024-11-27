package ddu.library.users;

import ddu.library.management.ddupack;  // Correct import

public class ddupack1 {
    ddupack a[];  // Array of ddupack objects
    int t;  // Tracks the number of elements in the array

    // Constructor
    public ddupack1() {
        a = new ddupack[5];  // Initialize the array
        t = 0;  // Set the initial count to 0
    }

    // Method to add a new user to the array
    public void add(String n, int i) {
        if (t < a.length) {  // Ensure there is space in the array
            a[t] = new ddupack(n, i);
            t++;
        } else {
            System.out.println("Array is full. Cannot add more users.");
        }
    }

    // Method to remove the last user
    public void remove() {
        if (t > 0) {
            a[t - 1] = null;  // Nullify the last element
            t--;  // Decrease the count
        } else {
            System.out.println("No users to remove.");
        }
    }

    // Method to print all users in the array
    public void print1() {
        for (int i = 0; i < t; i++) {
            System.out.println("Name: " + a[i].name);
            System.out.println("ID: " + a[i].id);
        }
    }

    // Main method to test functionality
    public static void main(String[] args) {
        ddupack1 p = new ddupack1();
        p.add("Mukti", 10);
        p.add("Mukti1", 120);
        p.add("Mukti3", 1043);
        p.add("Mukti4", 101);

        // Print users after adding them
        p.print1();

        // Remove two users and print again
        p.remove();
        p.remove();

        // Print users after removal
        p.print1();
    }
}
