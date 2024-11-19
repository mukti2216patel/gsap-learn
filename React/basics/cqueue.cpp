#include <iostream>
using namespace std;

class CircularQueue {
public:
    int size;
    int front, rear;
    int *queue;

    // Constructor to initialize the queue
    CircularQueue(int s) {
        size = s;
        front = rear = -1;
        queue = new int[size];  // Dynamically allocate memory for the queue
    }

    // Function to insert an element into the queue
    void insert(int n) {
        if (queuefull()) {
            cout << "Queue is full!" << endl;
        } else {
            if (front == -1) {
                front = rear = 0;  // Initialize front and rear for the first element
            } else {
                rear = (rear + 1) % size;  // Circular increment of rear
            }
            queue[rear] = n;
            cout << "Inserted: " << n << endl;
        }
    }

    // Function to delete an element from the queue
    void delet() {
        if (queueEmpty()) {
            cout << "Queue is empty!" << endl;
        } else {
            int n = queue[front];
            if (front == rear) {
                front = rear = -1;  // If only one element was present
            } else {
                front = (front + 1) % size;  // Circular increment of front
            }
            cout << "Deleted data is: " << n << endl;
        }
    }

    // Function to check if the queue is full
    bool queuefull() {
        return (front == (rear + 1) % size);  // Queue is full if front is just behind rear in a circular manner
    }

    // Function to check if the queue is empty
    bool queueEmpty() {
        return (front == -1);  // Queue is empty if front is -1
    }

    // Function to print the current elements in the queue
    void print() {
        if (queueEmpty()) {
            cout << "Queue is empty!" << endl;
        } else {
            int i = front;
            cout << "Queue elements: ";
            while (i != rear) {
                cout << queue[i] << " ";
                i = (i + 1) % size;  // Circular increment of i
            }
            cout << queue[rear] << endl;  // Print the last element
        }
    }

    // Destructor to free dynamically allocated memory
    ~CircularQueue() {
        delete[] queue;
    }
};

int main() {
    CircularQueue cq(5);  // Create a circular queue of size 5

    // Insert elements into the queue
    cq.insert(10);
    cq.insert(20);
    cq.insert(30);
    cq.insert(40);
    cq.insert(50);
    cq.insert(60);  // This will display "Queue is full!"

    // Print the queue
    cq.print();

    // Delete elements from the queue
    cq.delet();
    cq.delet();

    // Print the queue again
    cq.print();

    // Insert more elements
    cq.insert(60);
    cq.insert(70);

    // Final print of the queue
    cq.print();

    return 0;
}
