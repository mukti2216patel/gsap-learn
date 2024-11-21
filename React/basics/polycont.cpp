#include <iostream>
using namespace std;

struct Term {
    int coeff; // Coefficient of the term
    int exp;   // Exponent of the term
};

// Function to add two polynomials and return the result
void addPolynomials(Term poly1[], int size1, Term poly2[], int size2, Term result[], int &sizeResult) {
    int i = 0 , j = 0 , k = 0;
    while(i<size1 && j<size2)
    {
        if(poly1[i].exp > poly2[j].exp)
        {
            result[k].coeff = poly1[i].coeff;
            result[k].exp = poly1[i].exp;
            i++;
            k++;
        }
        else if(poly1[i].exp < poly2[j].exp)
        {
            result[k].coeff = poly2[j].coeff;
            result[k].exp = poly2[j].exp;
            j++;
            k++;
        }
        else
        {
            result[k].coeff = poly1[i].coeff + poly2[j].coeff;
            result[k].exp = poly1[i].exp;
            i++;
            j++;
            k++;
        }
    }
    while(i<size1)
    {
        result[k].coeff = poly1[i].coeff;
        result[k].exp = poly1[i].exp;
        i++;
    }
    while(j<size2)
    {
        result[k].coeff = poly2[j].coeff;
        result[k].exp = poly2[j].exp;
        j++;
        k++;
    }
    sizeResult = k;
}

// Function to print a polynomial
void printPolynomial(Term poly[], int size) {
    for (int i = 0; i < size; i++) {
        cout << poly[i].coeff << "x^" << poly[i].exp;
        if (i != size - 1) {
            cout << " + ";
        }
    }
    cout << endl;
}

int main() {
    // First polynomial: 5x^3 + 4x^2 + 2x + 1
    Term poly1[] = {
        {5, 3}, // 5x^3
        {4, 2}, // 4x^2
        {2, 1}, // 2x^1
        {1, 0}  // 1x^0
    };
    int size1 = sizeof(poly1) / sizeof(poly1[0]);

    // Second polynomial: 3x^3 + 6x^1 + 7
    Term poly2[] = {
        {3, 3}, // 3x^3
        {6, 1}, // 6x^1
        {7, 0}  // 7x^0
    };
    int size2 = sizeof(poly2) / sizeof(poly2[0]);

    // Resultant polynomial array (will store the sum)
    Term result[size1 + size2];  // Maximum size of the result polynomial
    int sizeResult = 0;

    // Perform polynomial addition
    addPolynomials(poly1, size1, poly2, size2, result, sizeResult);

    // Print the resulting polynomial
    cout << "Sum of the polynomials: ";
    printPolynomial(result, sizeResult);

    return 0;
}
