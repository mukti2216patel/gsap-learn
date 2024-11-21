#include<bits/stdc++.h>
using namespace std;
class st{
    public:
    int data;
    st* next;
    st():data(0) , next(nullptr){};
    st(int d):data(d)  , next(nullptr){};
};
void print(st* h)
{
    while(h!=NULL)
    {
        cout<<h->data<<" ";
        h=h->next;
    }
    cout<<endl;
}

void push(st* &head , int val)
{
    st* newnode = new st(val);
    st* th = head;
    while(th->next!=NULL)
    {
        th=th->next;
    }
    th->next=newnode;
}
void popst(st*& head)
{
    st* th = head;
    while(th->next->next!=NULL)
    {
        th=th->next;
    }
    th->next=NULL;
}
void popq(st*& head)
{
   st* th = head->next;
   head=th;
}
int main()
{
    int a[] = {1,2,3,4,5};
    st * head = new st();
    st* prev = nullptr;
    for(int i=0;i<5;i++)
    {
        if(i==0)
        {
            st * temp = new st(a[i]);
            head->next=temp;
            prev=temp;
        }
        else
        {
            st* temp = new st(a[i]);
            prev->next = temp;
            prev=temp;
        }
    }
    print(head);
    push(head , 111);
    print(head);
    push(head , 121);
    print(head);
    popq(head);
    print(head);
    popst(head);
    print(head);
}