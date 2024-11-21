#include <iostream>
#include <string>
using namespace std;
class call{
    public:
    string name;
    int ph;
};
class info{
    public:
    call q[100];
    int cap;
    int front;
    int rear;
    info()
    {
        cap=100;
        front =-1;
        rear = -1;
    }
    void add(string name , int ph)
    {
        if(rear+1==cap)
        {
            cout<<"q is full"<<endl;
            return;
        }
        rear = (rear+1)%cap;
        if(front==-1) front=0;
        q[rear].name=name;
        q[rear].ph =  ph;
    }
    void pop()
    {
        if(front > rear || front==-1)
        {
            cout<<"q is empty"<<endl;
            return; 
        }
        q[front].name = "";
        q[front].ph = 0;
        front = (front + 1)%cap;
    }
    void print() {
        if (front == -1) {
            cout << "Queue is empty" << endl;
            return;
        }
        int i = front;
        cout << "Current Queue: " << endl;
        while (i != rear) {
            cout << "Name: " << q[i].name << ", Phone: " << q[i].ph << endl;
            i = (i + 1) % cap;
        }
        cout << "Name: " << q[rear].name << ", Phone: " << q[rear].ph << endl;
    }
};
int main()
{
     info queue;  // Create an instance of the queue

    // Adding calls to the queue
    queue.add("John", 1234);
    queue.add("Alice", 9876);
    queue.add("Bob", 1125);
    queue.print();
    cout << "Added 3 callers to the queue." << endl;

    // Pop (remove) a caller from the queue
    queue.pop();
    cout << "Removed one caller from the queue." << endl;
    queue.print();
    // Adding another caller
    queue.add("Charlie", 57777);
    cout << "Added Charlie to the queue." << endl;

    // Removing all callers
    queue.pop();  // Removes Alice
    queue.pop();  // Removes Bob
    queue.print();
    queue.pop();  // Removes Charlie
    
    cout << "Removed all callers from the queue." << endl;

    // Try removing from an empty queue
    queue.pop();  // This should print "q is empty" as the queue is empty now

    return 0;
}