package PROYECTO;
import java.util.Arrays;

public class Kruskal {
    GraficoArbol grafico;
    // A class to represent a graph edge
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        // Comparator function used for sorting edgesbased on their weight
        @Override
        public int compareTo(Edge compareEdge){
            return this.weight - compareEdge.weight;
        }
    };
    // A class to represent a subset for union-find
    class subset {
        int parent, rank;
    };
    int V, E; // V-> no. of vertices & E->no.of edges
    Edge edge[]; // collection of all edges

    // Creates a graph with V vertices and E edges
    Kruskal(GraficoArbol grafico){
        V = grafico.vertices.size();
        E = grafico.aristas.size();
        edge = new Edge[E];
        for (int i = 0; i < E; ++i){
            Edge e = new Edge();
            e.dest = grafico.aristas.get(i).origen;
            e.src = grafico.aristas.get(i).destino;
            e.weight = grafico.aristas.get(i).getPeso();
            edge[i] = e;
        }
        this.grafico = grafico;
    }

    // A utility function to find set of an element i (uses path compression technique)
    int find(subset subsets[], int i){
        // find root and make root as parent of i
        // (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    // A function that does union of two sets of x and y (uses union by rank)
    void Union(subset subsets[], int x, int y){
            int xroot = find(subsets, x);
            int yroot = find(subsets, y);

            // Attach smaller rank tree under root of high rank tree (Union by Rank)
            if (subsets[xroot].rank < subsets[yroot].rank)
                    subsets[xroot].parent = yroot;
            else if (subsets[xroot].rank > subsets[yroot].rank)
                    subsets[yroot].parent = xroot;

            // If ranks are same, then make one as
            // root and increment its rank by one
            else {
                    subsets[yroot].parent = xroot;
                    subsets[xroot].rank++;
            }
    }

    // The main function to construct MST using Kruskal's algorithm
    void KruskalMST(){
        Edge result[] = new Edge[V]; // This will store the resultant MST
        int e = 0; // An index variable, used for result[]
        int i; // An index variable, used for sorted edges
        for (i = 0; i < V; ++i){
                result[i] = new Edge();
        }
        // Step 1: Sort all the edges in non-decreasing
        // order of their weight. If we are not allowed to
        // change the given graph, we can create a copy of
        // array of edges
        Arrays.sort(edge);

        // Allocate memory for creating V subsets
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
                subsets[i] = new subset();

        // Create V subsets with single elements
        for (int v = 0; v < V; ++v) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
        }

        i = 0; // Index used to pick next edge

        // Number of edges to be taken is equal to V-1
        while (e < V - 1) {
                // Step 2: Pick the smallest edge. And increment
                // the index for next iteration
                Edge next_edge = edge[i++];

                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);

                // If including this edge doesn't cause cycle,
                // include it in result and increment the index
                // of result for next edge
                if (x != y) {
                        result[e++] = next_edge;
                        Union(subsets, x, y);
                }
                // Else discard the next_edge
        }

        // print the contents of result[] to display the built MST
        System.out.println("Following are the edges in "
                                        + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
                System.out.println(result[i].src + " -- "
                                                + result[i].dest
                                                + " == " + result[i].weight);
                minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                                        + minimumCost);
    }
}
// This code is contributed by Aakash Hasija