#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int data;
    Node *next;
    Node *prev;

    Node(int val) : data(val), next(nullptr), prev(nullptr) {}
};

void insertEnd(Node *&head, int value)
{
    Node *newNode = new Node(value);
    if (!head)
    {
        head = newNode;
        return;
    }
    Node *temp = head;
    while (temp->next)
    {
        temp = temp->next;
    }
    temp->next = newNode;
    newNode->prev = temp;
}

// Function to delete two nodes after the node with data X
void deleteTwoNodesAfterX(Node *&head, int x)
{
    Node *temp = head;

    while (temp != nullptr && temp->data != x)
    {
        temp = temp->next;
    }

    if (temp != NULL)
    {
        if (temp->next != NULL)
        {
            if (temp->next->next != NULL)
            {
                Node *nodeToDelete1 = temp->next;          // First node to delete
                Node *nodeToDelete2 = nodeToDelete1->next; // Second node to delete
                temp->next = nodeToDelete2->next;          // Skipping two nodes

                // Update the prev pointer if there are any nodes after the deleted ones
                if (temp->next != NULL)
                {
                    temp->next->prev = temp;
                }

                // Delete the nodes
                delete nodeToDelete1;
                delete nodeToDelete2;
            }
            else
            {
                // Only one node exists after temp, so just remove it
                Node *nodeToDelete = temp->next;
                temp->next = NULL;
                delete nodeToDelete;
            }
        }
    }
}

// Function to print the doubly linked list
void printList(Node *head)
{
    Node *temp = head;
    while (temp != nullptr)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}
void delnd(Node *&h)
{
    if (h->prev)
        h->prev->next = h->next;
    else
        h = h->next;
}
// Function to remove duplicate nodes from the doubly linked list
void removeDuplicates(Node *&head)
{
    map<int, int> mp;
    Node *th = head;
    while (th != NULL)
    {
        if (mp[th->data] == 1)
        {
            delnd(th);
        }
        mp[th->data] = 1;
        th = th->next;
    }
}

int main()
{
    Node *head = nullptr;

    insertEnd(head, 10);
    insertEnd(head, 20);
    insertEnd(head, 30);
    insertEnd(head, 20); // Duplicate node
    insertEnd(head, 40);
    insertEnd(head, 20); // Duplicate node
    insertEnd(head, 50);

    cout << "Original List: ";
    printList(head);

    deleteTwoNodesAfterX(head, 20);
    cout << "List after deleting two nodes after 20: ";
    printList(head); // Expected Output: 10 20 50

    removeDuplicates(head);
    cout << "List after removing duplicates: ";
    printList(head); // Expected Output: 10 20 30 40 50

    return 0;
}
