#include<iostream>
using namespace std;
const int MAX = 5;
int adjacencyMatrix[MAX][MAX];

void Edge(int u, int v){
    adjacencyMatrix[u][v] = 1;
    adjacencyMatrix[v][u] = 1;
}

void PrintGraph(int nodes){
    for(int i = 0; i < nodes; i++){
        cout << i << " Linked with : ";
        for(int j = 0; j < nodes; j++){
            if(adjacencyMatrix[i][j] == 1){
                cout << j << ", ";  
            }
        }
        cout << endl;
    }
}
int main(){
    Edge(0,1);
    Edge(0,2);
    Edge(1,2);
    Edge(1,3);
    Edge(2,3);
    Edge(3,4);
    Edge(4,2);
    PrintGraph(MAX);


}