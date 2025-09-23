#include <bits/stdc++.h>
using namespace std;

int main() {
    int n = 5; // only nodes 1..5 exist

    // Adjacency list representation of the graph
    vector<vector<int>> g = {
        {},      // 0 (unused, for 1-based indexing)
        {2, 3},  // 1 -> 2, 3
        {3},     // 2 -> 3
        {4},     // 3 -> 4
        {5},     // 4 -> 5
        {}       // 5 (no outgoing edges)
    };

    vector<int> in(n + 1, 0), res; // indegree array and result

    // Calculate indegrees
    for (int u = 1; u <= n; u++) {
        for (int v : g[u]) {
            in[v]++;
        }
    }

    queue<int> q;
    // Add all nodes with indegree 0 to the queue
    for (int i = 1; i <= n; i++) {
        if (in[i] == 0) {
            q.push(i);
        }
    }

    // Kahn's algorithm for topological sort
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        res.push_back(u);
        for (int v : g[u]) {
            if (--in[v] == 0) {
                q.push(v);
            }
        }
    }

    // Print the topological order
    for (int x : res) {
        cout << x << " ";
    }
    cout << endl;
}

