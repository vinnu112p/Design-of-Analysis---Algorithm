#include <bits/stdc++.h>
using namespace std;

int main() {
    string txt = "ababcabcabababd";
    string pat = "ababd";

    int n = txt.size();
    int m = pat.size();

    int p = 31;
    int mod = 1e9 + 9;

    long long hp = 0;
    long long ht = 0;
    long long pow = 1;

    for (int i = 0; i < m; i++) {
        hp = (hp + (pat[i] - 'a' + 1) * pow) % mod;
        ht = (ht + (txt[i] - 'a' + 1) * pow) % mod;

        if (i < m - 1) {
            pow = (pow * p) % mod;
        }
    }

    for (int i = 0; i <= n - m; i++) {
        if (hp == ht) {
            cout << "Found at " << i << "\n";
        }

        if (i < n - m) {
            ht = (ht - (txt[i] - 'a' + 1) + mod) % mod;
            ht = (ht / p) % mod;  // rolling hash adjustment
            ht = (ht + (txt[i + m] - 'a' + 1) * pow) % mod;
        }
    }

    return 0;
}
