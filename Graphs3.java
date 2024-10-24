import java.util.*;

public class Graphs3 {
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
    graph[0].add(new Edge(0, 3));
    graph[2].add(new Edge(2, 3));

    graph[3].add(new Edge(3, 1));

    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));

    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));

  }


  static class Edge2 {
    int src;
    int dest;
    int wt;

    public Edge2(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;
    }
  }


  static void createGraphWithWeight(ArrayList<Edge2> graph2[]) {
    for(int i=0; i<graph2.length; i++) {
      graph2[i] = new ArrayList<>();
    }
    graph2[0].add(new Edge2(0, 1, 2));
    graph2[0].add(new Edge2(0, 2, 4));

    graph2[1].add(new Edge2(1, 3 , 2));
    graph2[1].add(new Edge2(1, 2, 1));

    graph2[2].add(new Edge2(2, 4, 3));

    graph2[3].add(new Edge2(3, 5, 1));

    graph2[4].add(new Edge2(4, 3, 2));
    graph2[4].add(new Edge2(4, 5, 5));

  }

  
  public static void calIndegree(ArrayList<Edge>[] graph, int indegree[]) {
    for(int i=0; i<graph.length; i++) {
      int v = i;
      for(int j=0; j<graph[v].size(); j++) {
        Edge e = graph[v].get(j);
        indegree[e.dest]++;
      }
    }
  }

  public static void topSort(ArrayList<Edge>[] graph) {
    int indegree[] = new int[graph.length];
    calIndegree(graph, indegree);
    Queue<Integer> q = new LinkedList<>();

    for(int i=0; i<indegree.length; i++) {
      if(indegree[i] == 0) {
        q.add(i);
      }
    }

    //bfs
    while(!q.isEmpty()) {
      int curr = q.remove();
      System.out.print(curr + " ");

      for(int i=0; i<graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        indegree[e.dest]--;
        if(indegree[e.dest] == 0) {
          q.add(e.dest);
        }
      }
    }
    System.out.println();
  }

  public static void printAllPaths( ArrayList<Edge>[] graph, int src, int dest, String path) { // exponential time complexity
    if(src == dest) {
      System.out.println(path + dest);
      return;
    }

    for(int i=0; i<graph[src].size(); i++) {
      Edge e = graph[src].get(i);
      printAllPaths(graph, e.dest, dest, path+src);
    }
  }
  
  static class Pair implements Comparable<Pair> {
    int n;
    int path;

    public Pair(int n, int path) {
      this.n = n;
      this.path = path;
    }

    @Override
    public int compareTo(Pair p2) {
      return this.path - p2.path; // path based sorting for my pairs
    }
  }


  public static void dijkstra(ArrayList<Edge2>[] graph2, int src) {  // TIME COMPLEXITY is O(V + ElogV) {using priority queue}
    int dist[] = new int[graph2.length]; // dist[i] -> src to i
    for(int i = 0; i<graph2.length; i++) {
      if(i != src) {
        dist[i] = Integer.MAX_VALUE; // +INFINITY
      }
    }

    boolean visit[] = new boolean[graph2.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>(); 
    pq.add(new Pair(src, 0));

    while(!pq.isEmpty()) {
      Pair curr = pq.remove();
      if(!visit[curr.n]) {
        visit[curr.n] = true;
        for(int i=0; i<graph2[curr.n].size(); i++) {
          Edge2 e2 = graph2[curr.n].get(i);
          int u = e2.src;
          int v = e2.dest;
          int wt = e2.wt;

          if(dist[u]+wt < dist[v]) {
            dist[v] = dist[u] + wt;
            pq.add(new Pair(v, dist[v]));
          }
        }
      }
    }
    // print all source to vertices shortest paths
    for(int i=0; i<dist.length; i++) {
      System.out.print(dist[i] + " ");
    }
    System.out.println();
  }
  public static void main(String[] args) {
    // int v = 6;
    // ArrayList<Edge>[] graph = new ArrayList[v];
    // createGraph(graph);

    // // topological sort(using bfs)
    // topSort(graph);


    // // all paths from source to target(directed graph)
    // int src = 5, dest = 1;
    // printAllPaths(graph, src, dest, " ");





    // // Dijkstra's algorithm
    // int V = 6;
    // ArrayList<Edge2>[] graph2 = new ArrayList[V];
    // createGraphWithWeight(graph2);

    // int src = 0;
    // dijkstra(graph2, src);










    // ASSIGNMENT QUES
    
  }
}
