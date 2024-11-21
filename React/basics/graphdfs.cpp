#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Graph {
public:
    int V;  // Number of vertices
    vector<int>* adj;  // Adjacency list

    Graph(int V) {
        this->V = V;
        adj = new vector<int>[V];
    }

    // Function to add an edge to the graph
    void addEdge(int u, int v) {
        adj[u].push_back(v);
        adj[v].push_back(u);  // For undirected graph
    }

    // Recursive DFS function
    void DFS(int v, vector<bool>& visited) {
        visited[v] = true;  // Mark the node as visited
        cout << v << " ";   // Print the node

        // Recur for all the vertices adjacent to this vertex
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }

    // Function to perform DFS traversal
    void DFS_Traversal(int start) {
        vector<bool> visited(V, false);  // Create a visited array
        DFS(start, visited);  // Call the recursive DFS function
    }
};

int main() {
    // Create a graph with 6 vertices
    Graph g(6);

    // Add edges to the graph
    g.addEdge(0, 1);  // A-B
    g.addEdge(0, 2);  // A-C
    g.addEdge(1, 3);  // B-D
    g.addEdge(2, 4);  // C-E
    g.addEdge(2, 5);  // C-F

    cout << "DFS traversal starting from vertex A (0): ";
    g.DFS_Traversal(0);  // Start DFS traversal from vertex 0 (A)
    
    return 0;
}
