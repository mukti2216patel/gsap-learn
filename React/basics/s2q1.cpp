#include<bits/stdc++.h>
using namespace std;

class a {
public:
    string data;
};

class b {
public:
    a arr[10];
    int size;
    int front;
    int rear;

    b() {
        size = 10;
        front = -1;
        rear = -1;
    }

    void insert(string n) {
        if ((rear + 1) % size == front) { // Check if the queue is full
            cout << "Queue is full, overwriting the oldest data." << endl;
            front = (front + 1) % size; // Move front to overwrite the oldest data
        }
        
        rear = (rear + 1) % size;
        arr[rear].data = n;

        if (front == -1) { // Initially, when the queue is empty, set front to 0
            front = 0;
        }
    }

    void pop() {
        if (front == -1) { // Check if the queue is empty
            cout << "Queue is empty" << endl;
            return;
        }

        cout << "Removing data: " << arr[front].data << endl;
        arr[front].data = ""; // Remove the data
        if (front == rear) { // If there's only one element left, reset the queue
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    void printQueue() {
        if (front == -1) {
            cout << "Queue is empty" << endl;
            return;
        }

        int i = front;
        while (i != rear) {
            cout << arr[i].data << " ";
            i = (i + 1) % size;
        }
        cout << arr[rear].data << endl;
    }
};

int main() {
    b q;

    q.insert("Audio1");
    q.insert("Audio2");
    q.insert("Audio3");
    q.insert("Audio4");
    q.printQueue();

    q.pop();  // Removes "Audio1"
    q.printQueue();

    q.insert("Audio5");
    q.insert("Audio6");
    q.printQueue();

    q.pop();  // Removes "Audio2"
    q.printQueue();

    return 0;
}
