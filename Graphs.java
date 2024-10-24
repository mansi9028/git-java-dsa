import java.util.*;

public class Graphs {
  static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;

    }
  }


  static void createGraph(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<Edge>();
    }

    // at 0 vertex
    graph[0].add(new Edge(0, 1, 1));

    // at 1 vertex
    graph[1].add(new Edge(1, 0, 1));
    graph[1].add(new Edge(1, 2, 1));
    graph[1].add(new Edge(1, 3, 1));

    // at 2 vertex
    graph[2].add(new Edge(2, 1, 1));
    graph[2].add(new Edge(2, 3, 1));
    graph[2].add(new Edge(2, 4, 1));

    // at 3 vertex
    graph[3].add(new Edge(3, 1, 1));
    graph[3].add(new Edge(3, 2, 1));

    // at 4 vertex
    graph[4].add(new Edge(4, 2, 1));

    //     // for neighbour's
    // // for eg. 2's neighbour's
    // for(int i=0; i<graph[2].size(); i++) {
    //   Edge e = graph[2].get(i); // src, dest, wt
    //   System.out.println(e.dest);
    // }
  }

  public static void bfs(ArrayList<Edge>[] graph) {
    boolean visited[] = new boolean[graph.length];
    for(int i=0; i<graph.length; i++) {
      if(!visited[i]) {
        bfsUtil(graph, visited);
      }
    }
  }

  // using adajency list
  public static void bfsUtil(ArrayList<Edge>[] graph, boolean visited[]) {  // O(V+E) yha V = vertex, E = edge; inmein se jo bhi jyada ho vhi time complexity hogi
    Queue<Integer> q = new LinkedList<>();
    q.add(0); // source = 0

    while(!q.isEmpty()) {
      int curr = q.remove();

      if(!visited[curr]) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
          Edge e = graph[curr].get(i);
          q.add(e.dest);
        }
      }
    }
  }


  public static void dfs(ArrayList<Edge>[] graph) {
    boolean visit[] = new boolean[graph.length];
    for(int i=0; i<graph.length; i++) {
      dfsUtil(graph, i, visit);
    }
  }
  public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean visit[]) { // O(V+E)
    // visit
    System.out.print(curr + " ");
    visit[curr] = true;

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if(!visit[e.dest]) {
        dfsUtil(graph, e.dest, visit);
      }
    }

  }


  public static void main(String[] args) {
    // int v = 5;
    // ArrayList<Edge> graph[] = new ArrayList[v];
    // createGraph(graph);
    
    
    // bfs(graph);

    // dfs(graph, v, new boolean[v]);

    
    
    
  }
}
