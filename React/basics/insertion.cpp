#include <bits/stdc++.h>
using namespace std;
void simplemerge(int arr[] , int i , int m , int j)
{
    int n = j - i + 1;
    int result[n];
    int k = i , k1 = m+1;
    int q=0;
    while(k<=m && k1<=j)
    {
        if(arr[k]<arr[k1])
        {
            result[q] = arr[k];
            k++;
        }
        else
        {
            result[q] = arr[k1];
            k1++;
        }
        q++;
    }
    while(k<=m)
    {
        result[q]=arr[k];
        k++;
        q++;
    }
    while(k1<=j)
    {
        result[q]=arr[k1];
        k1++;
        q++;
    }
    for(int s =0;s<n;s++)
    {
        arr[i+s] = result[s];
    }
}
void recurmerge(int arr[] , int i , int j)
{
    if(i<j)
    {
        int m = (i+j)/2;
        recurmerge(arr , i , m);
        recurmerge(arr , m+1 , j);
        simplemerge(arr , i , m, j);
    }
}

int main() {
    int arr[] = {11, 33, 2, 1, 44, 23};  
    int n = sizeof(arr) / sizeof(arr[0]);  

    recurmerge(arr, 0, n - 1);
    
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }

    return 0;
}
