#include<bits/stdc++.h>
#include<iostream>
using namespace std;
class abc{
    public:
    int arr[10];
    int max;
    int curr;
    abc()
    {
        max=10;
        curr = 0;
    }
    void push(int num)
    {
        if(max==curr) {
            cout<<"it is full";
        }
        else
        {
            arr[curr]=num;
            curr++;
        }
    }
    void pop()
    {
        if(curr<0) 
        {
            cout<<"it is empty";
        }
        else
        {
            arr[curr]=0;
            curr--;
        }
    }
    bool iem()
    {
        if(curr==0) return true;
        else return false;
    }
    bool isfull()
    {
        if(max==curr) return true;
        else return false;
    }
    void print()
    {
        for(int i=0;i<=curr;i++)
        {
            cout<<arr[i]<<" ";
        }
    }
};
int main()
{
    abc a = *(new abc());
    a.push(10);
    a.push(20);
    a.push(30);
    a.push(40);
    a.push(50);
    a.pop();
    a.pop();
    a.pop();
    a.print();
    if(a.iem())
    cout<<"yes empty";
    if(a.isfull())
    cout<<"yes full";
}