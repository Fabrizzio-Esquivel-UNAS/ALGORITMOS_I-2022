package PROYECTO;
import java.util.Arrays;
import java.util.stream.Stream;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class Kruskal{    
    @Param("")
    String p;
    @Setup(Level.Invocation)
    public void Setup(){
        V = E = 0;
        Stream<String> plines = p.lines();
        plines.forEach(l -> {
            String a[] = l.split(",");            
            if (V==0){
                V = Integer.parseInt(a[0]);
                edge = new Edge[Integer.parseInt(a[1])];
            }else{
                Edge e = new Edge();
                e.dest = Integer.parseInt(a[0]);
                e.src = Integer.parseInt(a[1]);
                e.weight = Integer.parseInt(a[2]);
                edge[E] = e;
                E++;
            }
        });        
    }    

    // A class to represent a graph edge
    public class Edge implements Comparable<Edge> {
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
    @Benchmark
    public Edge[] MST(){
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
                        //grafico.aristas[i].color = Color.RED;
                        //grafico.vertices[grafico.aristas[i].origen].color = Color.LIGHT_GRAY;
                        result[e++] = next_edge;
                        Union(subsets, x, y);
                }
                // Else discard the next_edge
        }
        return result;
    }
}
// This code is contributed by Aakash Hasija