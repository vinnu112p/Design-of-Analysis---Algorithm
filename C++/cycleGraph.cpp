#include <iostream>
using namespace std;

const int MAX = 100;  // Maximum number of vertices

int graph[MAX][MAX];  // Adjacency matrix
bool visited[MAX];    // To track visited nodes
bool recStack[MAX];   // To track nodes in the current DFS path

bool isCyclicUtil(int v, int V) {
    visited[v] = true;
    recStack[v] = true;

    // Check all neighbors
    for (int u = 0; u < V; u++) {
        if (graph[v][u]) {  // If there is an edge v -> u
            if (!visited[u] && isCyclicUtil(u, V))
                return true;  // Found a cycle
            else if (recStack[u])
                return true;  // Back edge found
        }
    }

    recStack[v] = false;  // Remove from recursion stack
    return false;
}

bool isCyclic(int V) {
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            if (isCyclicUtil(i, V))
                return true;
        }
    }
    return false;
}

int main() {
    int V, E;
    cout << "Enter number of vertices: ";
    cin >> V;

    cout << "Enter number of edges: ";
    cin >> E;

    // Initialize graph
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            graph[i][j] = 0;
        }
        visited[i] = false;
        recStack[i] = false;
    }

    cout << "Enter edges (u v):\n";
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        graph[u][v] = 1;  // Directed edge u → v
    }

    if (isCyclic(V))
        cout << "Graph contains a cycle\n";
    else
        cout << "Graph does NOT contain a cycle\n";

    return 0;
}
