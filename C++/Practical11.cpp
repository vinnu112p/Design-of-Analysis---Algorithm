#include <iostream>
#include <string>
using namespace std;
string RemoveKthDigit(string num,int k)
{
    int n = num.size();
    char stack[10001];
    int top = -1;
    for(int i = 0 ; i < n ; i++)
    {
        char digit = num[i];
        while (k > 0 && top >= 0 && stack[top] > digit)
        {
            top--;
            k--;
        }
        stack[++top] = digit;
    }
    top -= k;
    
    string result = "";
    for(int i = 0 ; i <=top ; i++)
    {
        result += stack[i];
    }
    
    int start = 0 ;
    while (start < result.size() && result[start]=='0')
    {
        start++;
    }
    result = result.substr(start);
    
    return result.empty() ? "0" : result;
}
int main() {
    string num = "1432219";
    int k = 3 ;
    cout << RemoveKthDigit(num,k);
    return 0;
}