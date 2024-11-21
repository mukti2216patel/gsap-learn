#include <iostream>
using namespace std;

class Node
{
public:
    int data;
    Node *left;
    Node *right;
    Node(int value)
    {
        data = value;
        left = right = nullptr;
    }
};

Node* insert(Node* root, int value)
{
    if (root == nullptr)
        return new Node(value);

    if (root->data > value)
    {
        root->left = insert(root->left, value);
    }
    else if (root->data < value)
    {
        root->right = insert(root->right, value);
    }
    else
    {
        cout << "Duplicate value" << endl;
    }

    return root;
}

bool search(Node* root, int value)
{
    if (root == nullptr)
    {
        return false;
    }

    if (root->data > value)
    {
        return search(root->left, value);
    }
    else if (root->data < value)
    {
        return search(root->right, value);
    }
    
    return true;  // Value is found
}

void inorder(Node* root)
{
    if (root != nullptr)
    {
        inorder(root->left);
        cout << root->data << " ";
        inorder(root->right);
    }
}

int main()
{
    Node* root = nullptr;

    // Inserting nodes into the BST
    root = insert(root, 15);
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 8);
    root = insert(root, 12);
    root = insert(root, 18);
    root = insert(root, 25);

    // Inorder traversal of the BST
    cout << "Inorder Traversal: ";
    inorder(root);  // Output should be: 8 10 12 15 18 20 25
    cout << endl;

    // Searching for values in the BST
    int searchVal = 12;
    if (search(root, searchVal))
    {
        cout << searchVal << " found in the BST." << endl;
    }
    else
    {
        cout << searchVal << " not found in the BST." << endl;
    }

    searchVal = 50;
    if (search(root, searchVal))
    {
        cout << searchVal << " found in the BST." << endl;
    }
    else
    {
        cout << searchVal << " not found in the BST." << endl;
    }

    return 0;
}
