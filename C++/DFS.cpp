#include <iostream>
using namespace std;

const int MAX = 100;
int graph[MAX][MAX];
bool visited[MAX];

void dfs(int u, int V) {
    visited[u] = true;
    cout << u << " ";  // ✅ Print when visiting

    // Visit all neighbors of u
    for (int i = 0; i < V; i++) {
        if (graph[u][i] && !visited[i]) {
            dfs(i, V);
        }
    }
}

void addEdge(int u, int v) {
    graph[u][v] = 1;  // Directed graph
}

int main() {
    int V = 4;

    // Initialize graph and visited
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            graph[i][j] = 0;
        }
        visited[i] = false;
    }

    // Create a directed graph
    addEdge(0, 1);
    addEdge(1, 2);
    addEdge(2, 3);
    addEdge(3, 1);

    cout << "DFS Traversal: ";
    dfs(0, V);

    return 0;
}
