#include<bits/stdc++.h>
using namespace std;
int ispr(char c)
{
    if(c=='*' || c=='/') return 5;
    else if(c=='+' || c=='-') return 4;
    else if(c=='<' || c=='>')  return 3;
    else if(c=='=' || c=='!') return 2;
    else if(c=='&') return 1;
    else if(c=='|') return 0;
    else return -1;
}
int main()
{
    string s = "(a*(b+c))/d";
    stack<char>st;
    for(int i=0;i<s.length();i++)
    {
        if(isalpha(s[i]))
        {
            cout<<s[i];
        }
        else if(s[i]=='(')
        {
            st.push('(');
        }
        else if(s[i]==')')
        {
            while(st.top()!='(')
            {
                cout<<st.top();
                st.pop();
            }
            st.pop();
        }
        else
        {
            while(!st.empty() && ispr(st.top())>ispr(s[i]))
            {
                cout<<st.top();
                st.pop();
            }
            st.push(s[i]);
        }
    }
    while(!st.empty())
    {
        cout<<st.top();
        st.pop();
    }
}