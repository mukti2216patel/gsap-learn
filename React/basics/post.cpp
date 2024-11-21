#include<bits/stdc++.h>
using namespace std;

int main() {
    string s = "123+3*3/";  // Input postfix expression with only single digits
    stack<int> st;

    for (int i = 0; i < s.length(); i++) {
        if (isdigit(s[i])) {  // If the character is a digit (single digit)
            int num = s[i] - '0';  // Convert char to int
            st.push(num);  // Push the digit onto the stack
        }
        else {  // If the character is an operator
            int b = st.top(); 
            st.pop();
            int a = st.top();
            st.pop();

            if (s[i] == '+')
                st.push(a + b);
            else if (s[i] == '-')
                st.push(a - b);
            else if (s[i] == '/')
                st.push(a / b);
            else if (s[i] == '*')
                st.push(a * b);
        }
    }

    // The final result will be the only element left in the stack
    cout << st.top() << endl;  // Output the result
    return 0;
}
