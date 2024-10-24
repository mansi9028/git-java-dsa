import java.util.*;

public class Graphs2 {
  static class Edge {
    int src;
    int dest;

    public Edge(int s, int d) {
      this.src = s;
      this.dest = d;
    }
  }

  static void createGraph(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1)); 
    graph[0].add(new Edge(0, 2)); 
    graph[0].add(new Edge(0, 3)); 

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));

    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 1));

    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 4));

    graph[4].add(new Edge(4, 3));
  }

  public static boolean detectCycle(ArrayList<Edge>[] graph) {
    boolean visit[] = new boolean[graph.length];
    for(int i=0; i<graph.length; i++) {
      if(!visit[i]) {
        if(detectCycleUtil(graph, visit, i, -1)) {
          return true; // cycle exists for one of the parts
        }
      }
    }
    return false;
  }

  public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean visit[], int curr, int parent) {
    visit[curr] = true;

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if(!visit[e.dest]) {
        if(detectCycleUtil(graph, visit, e.dest, curr)) {
        return true;
        }
      }

      else if(visit[e.dest] && e.dest != parent) {
        return true;
      }
      // case - DO NOTHING -> CONTINUE
    }
    return false;
  }

  public static boolean isBipartite(ArrayList<Edge>[] graph) {
    int color[] = new int[graph.length];
    for(int i=0; i<color.length; i++) {
      color[i] = -1; // no color
    }

    Queue<Integer> q = new LinkedList<>();

    for(int i=0; i<graph.length; i++) {
      if(color[i] == -1) {
        q.add(i);
        color[i] = 0; // yellow
        while(!q.isEmpty()) {
          int curr = q.remove();
          for(int j=0; j<graph[curr].size(); j++) {
            Edge e = graph[curr].get(j); // e.dest
            if(color[e.dest] == -1) {
              int nextColor = color[curr] == 0 ? 1 : 0;
              color[e.dest] = nextColor;
              q.add(e.dest);
            } else if(color[e.dest] == color[curr]) {
              return false; // graph not bipartite
            }
          }
        }
      }
    }
    return true;
  }

  public static boolean isCycle(ArrayList<Edge>[] graph) {
    boolean visit[] = new boolean[graph.length];
    boolean stack[] = new boolean[graph.length];

    for(int i=0; i<graph.length; i++) {
      if(!visit[i]) {
        if(isCycleUtil(graph, i, visit, stack)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean visit[], boolean stack[]) {
    visit[curr] = true;
    stack[curr] = true;

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if(stack[e.dest]) { // cycle
        return true;  
      }
      if(!visit[e.dest] && isCycleUtil(graph, e.dest, visit, stack)) {
      return true;
      }
    }
    stack[curr] = false;
    return false;
  }

  // topologivcal sorting
  public static void topSort(ArrayList<Edge>[] graph) {
    boolean visit[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();

    for(int i=0; i<graph.length; i++) {
      if(!visit[i]) {
        topSortUtil(graph, i, visit, s); // this is our modified DFS function
      }
    }
    while(!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean visit[], Stack<Integer> s) {
    visit[curr] = true;

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if(!visit[e.dest]) {
        topSortUtil(graph, e.dest, visit, s);
      }
    }
    s.push(curr);
  }
  public static void main(String args[]) {
    // int v = 5;
    // ArrayList<Edge> graph[] = new ArrayList[v];
    // createGraph(graph);

    // System.out.println(detectCycle(graph));


    // // Bipartite graph
    // System.out.println(isBipartite(graph));


    // // cycle detection - directed graph
    // System.out.println(isCycle(graph));


    // // topological sorting
    // topSort(graph);



  }
}
