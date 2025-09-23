#include <bits/stdc++.h>
using namespace std;

#define NOCHAR 256

vector<vector<int>> FA(string pat) {
    int m = pat.size();
    vector<vector<int>> tf(m + 1, vector<int>(NOCHAR));

    for (int x = 0; x <= m; x++) {
        for (int c = 0; c < NOCHAR; c++) {
            int k = min(m, x + 1);

            while (k > 0 && pat.substr(0, k) != pat.substr(x - k + 1, k)) {
                k--;
            }

            tf[x][c] = k;
        }
    }

    return tf;
}

int main() {
    string txt = "ababcababa";
    string pat = "aba";

    auto tf = FA(pat);
    int m = pat.size();
    int state = 0;

    for (int i = 0; i < txt.size(); i++) {
        state = tf[state][txt[i]];

        if (state == m) {
            cout << "Found at " << i - m + 1 << "\n";
        }
    }

    return 0;
}
