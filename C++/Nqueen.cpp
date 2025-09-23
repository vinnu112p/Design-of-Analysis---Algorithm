#include <bits/stdc++.h>
using namespace std;

int n = 4;
vector<int> col(20);
vector<int> d1(40);
vector<int> d2(40);
vector<int> row(20);

void solve(int r) {
    if (r == n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == j) {
                    cout << "Q ";
                } else {
                    cout << ". ";
                }
            }
            cout << "\n";
        }
        cout << "\n";
        return;
    }

    for (int c = 0; c < n; c++) {
        if (!col[c] && !d1[r - c + n] && !d2[r + c]) {
            row[r] = c;
            col[c] = 1;
            d1[r - c + n] = 1;
            d2[r + c] = 1;

            solve(r + 1);

            col[c] = 0;
            d1[r - c + n] = 0;
            d2[r + c] = 0;
        }
    }
}

int main() {
    solve(0);
}
