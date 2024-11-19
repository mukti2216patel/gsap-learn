#include <bits/stdc++.h>
using namespace std;

class sol {
public:
    int max;
    int a[10];
    int rear;
    int front;

    // Constructor to initialize the queue
    sol() {
        max = 10;
        rear = 0;
        front = 0;
    }

    // Enqueue function to add an element to the queue
    void enqueue(int d) {
        if (!isfull()) {
            a[rear] = d;
            rear++;
        } else {
            cout << "Queue is full!" << endl;
        }
    }

    // Dequeue function to remove an element from the queue
    void dequeue() {
        if (isempty()) {
            cout << "Queue is empty!" << endl;
        } else {
            a[front] = 0;  // Optional: Set dequeued element to 0
            front++;
        }
    }

    // Check if the queue is full
    bool isfull() {
        if (rear == max) {
            return true;
        }
        return false;
    }

    // Check if the queue is empty
    bool isempty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    // Function to print the queue
    void print() {
        for (int i = front; i < rear; i++) {
            cout << a[i] << " ";
        }
        cout << endl;
    }
};

int main() {
    sol s;  // No need to use 'new'
    
    // Enqueue some elements
    s.enqueue(10);
    s.enqueue(20);
    s.enqueue(30);
    s.enqueue(40);
    
    // Print the queue
    s.print();
    
    // Dequeue two elements
    s.dequeue();
    s.dequeue();
    
    // Print the queue again
    s.print();
    
    // Dequeue remaining elements
    s.dequeue();
    s.dequeue();
    s.dequeue();  // This should print "Queue is empty!"
    
    return 0;
}
