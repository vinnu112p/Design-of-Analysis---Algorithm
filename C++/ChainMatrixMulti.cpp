#include <bits/stdc++.h>
using namespace std;
int mcm(vector<int> &p, int n)
{
    vector<vector<int>> dp(n, vector<int>(n, 0));
    for (int L = 2; L < n; L++)
    {
        for (int i = 1; i < n - L + 1; i++)
        {
            int j = i + L - 1;
            dp[i][j] = 1e9;
            for (int k = i; k < j; k++)
            {
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j]);
            }
        }
    }
    return dp[1][n - 1];
}
int main()
{
    vector<int> arr = {1, 2, 3, 4}; // 3 matrices: 1x2, 2x3, 3x4
    cout << "Min multiplications: " << mcm(arr, arr.size());
}
