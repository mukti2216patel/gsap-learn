// Class B extends class A and is in the same package "pack"
package pack;

public class B extends A {
    
    // Method to display values of the variables from class A
    public void display() {
        // Accessing the public variable directly
        System.out.println("Public variable from A: " + publicVar);
        
        // Accessing the protected variable directly (since we are in the same package)
        System.out.println("Protected variable from A: " + protectedVar);
        
        // Accessing the private variable via the public getter method
        System.out.println("Private variable from A: " + getPrivateVar());
    }
}
