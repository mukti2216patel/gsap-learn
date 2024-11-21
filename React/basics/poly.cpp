#include <iostream>
using namespace std;

// Define the Node structure to represent a term in the polynomial
class poly {
public:
    int coff;   // coefficient of the term
    int exp;    // exponent of the term
    poly* next; // Pointer to the next term

    poly() : coff(0), exp(0), next(nullptr) {} // Default constructor
    poly(int coeff, int exp) : coff(coeff), exp(exp), next(nullptr) {} // Parameterized constructor
};


void insertTerm(int c, int e, poly*& h) {
    if (h == nullptr) {
        h = new poly(c, e); // First term in the polynomial
        return;
    }

    poly* th = h;
    while (th->next != nullptr) {
        th = th->next; // Traverse to the last term
    }
    th->next = new poly(c, e); // Add new term at the end
}

void print(poly* head) {

    while (head != nullptr) {
        cout << head->coff << "x^" << head->exp;
        if (head->next != nullptr) {
            cout << " + "; // Don't print '+' for the last term
        }
        head = head->next;
    }
    cout << endl;
}
void add(poly* h, poly* h1, poly*& th2) {
    poly* th = h;
    poly* th1 = h1;
    poly* nh = nullptr;  // To hold the result polynomial head

    // Traverse both polynomials and add terms
    while (th != nullptr && th1 != nullptr) {
        if (th->exp > th1->exp) {
            if (nh == nullptr) {
                nh = new poly(th->coff, th->exp);  // First term in the result
                th2 = nh; // Set th2 to the head of the result
            } else {
                nh->next = new poly(th->coff, th->exp); // Add term to result
                nh = nh->next; // Move to the newly added term
            }
            th = th->next;
        } else if (th->exp < th1->exp) {
            if (nh == nullptr) {
                nh = new poly(th1->coff, th1->exp);  // First term in the result
                th2 = nh;
            } else {
                nh->next = new poly(th1->coff, th1->exp); // Add term to result
                nh = nh->next;
            }
            th1 = th1->next;
        } else {
            if (nh == nullptr) {
                nh = new poly(th->coff + th1->coff, th->exp);  // Add coefficients if exponents are equal
                th2 = nh;
            } else {
                nh->next = new poly(th->coff + th1->coff, th->exp); // Add term to result
                nh = nh->next;
            }
            th = th->next;
            th1 = th1->next;
        }
    }

    // If remaining terms in h
    while (th != nullptr) {
        nh->next = new poly(th->coff, th->exp);
        nh = nh->next;
        th = th->next;
    }

    // If remaining terms in h1
    while (th1 != nullptr) {
        nh->next = new poly(th1->coff, th1->exp);
        nh = nh->next;
        th1 = th1->next;
    }
}

int main() {
    poly* head = nullptr; // Initially, the polynomial is empty
    poly * head1 = nullptr;
    insertTerm(5, 3, head);  // 5x^3
    insertTerm(4, 2, head);  // 4x^2
    insertTerm(2, 1, head);  // 2x^1
    insertTerm(1, 0, head);  // 1x^0

    print(head); // Print the polynomial: 5x^3 + 4x^2 + 2x^1 + 1x^0

    insertTerm(3, 3, head1);  
    insertTerm(2, 2, head1);  
    insertTerm(6, 0, head1);

    print(head1);
    poly* head2 ;
    add(head , head1 , head2);
    print(head2);
    return 0;
}
