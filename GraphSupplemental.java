import java.util.*;

public class GraphSupplemental {
  static class Edge {
    int src;
    int dest;

    public Edge(int s, int d) {
      this.src = s;
      this.dest = d;
    }
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<Edge>();
    }

    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));

    graph[2].add(new Edge(2, 1));

    graph[3].add(new Edge(3, 4));
  }

  public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
    vis[curr] = true;

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if(!vis[e.dest]) {
        topSort(graph, e.dest, vis, s);
      }
    }
    s.push(curr);
  }

  public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
    vis[curr]= true;
    System.out.print(curr + " ");

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if(!vis[e.dest]) {
        dfs(graph, e.dest, vis);
      }
    }    
  }

  public static void kosaraju(ArrayList<Edge> graph[], int v) { // O(V + E)
    Stack<Integer> s = new Stack<>();
    boolean vis[] = new boolean[v];

    for(int i=0; i<v; i++) {
      if(!vis[i]) {
        topSort(graph, i, vis, s);
      }
    }

    ArrayList<Edge> transpose[] = new ArrayList[v];
    for(int i=0; i<transpose.length; i++) {
      vis[i] = false;
        transpose[i] = new ArrayList<Edge>();
      } 

    for(int i =0; i<v; i++) {
      for(int j=0; j<graph[i].size(); j++) {
        Edge e = graph[i].get(j);
        transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse edge
      }
    }

    while(!s.isEmpty()) {
      int curr = s.pop();
      if(!vis[curr]) {
        System.out.print("SCC -> ");
        dfs(transpose, curr, vis);
        System.out.println();
      }
    }
  }



  


  public static void dfs2(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean visit[], int time) {

    visit[curr] = true;
    dt[curr] = low[curr] = ++time; // st -> discovery time

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if(e.dest == par) {
        continue;
      } else if(!visit[e.dest]) {
        dfs2(graph, e.dest, par, dt, low, visit, time);
        low[curr] = Math.min(low[curr], low[e.dest]);
        if(dt[curr] < low[e.dest]) {
          System.out.println("Bridge : " + curr + " ------ "  + e.dest);
        }
      } else {
        low[curr] = Math.min(low[curr], dt[e.dest]);
      }
    }
  }

  public static void tarjanBridge(ArrayList<Edge> graph[], int v) {
    int dt[] = new int[v];
    int low[] = new int[v];
    int time = 0;
    boolean visit[] = new boolean[v];

    for(int i=0; i<v; i++) {
      if(!visit[i]) {
        dfs2(graph, i, -1, dt, low, visit, time);
      }
    }
  }








  public static void dfs3(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean visited[], boolean ap[]) {
    visited[curr] = true;
    dt[curr] = low[curr] = ++time;
    int children = 0;

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      int neigh = e.dest; // neigh = neighbor

      if(par == neigh) {
        continue;
      } else if(visited[neigh]) {
        low[curr] = Math.min(low[curr], dt[neigh]);
      } else {
        dfs3(graph, neigh, curr, dt, low, time, visited,ap);
        low[curr] = Math.min(low[curr], low[neigh]);
        if(par!=-1 && dt[curr] <= low[neigh]) {
          ap[curr] = true;
        }
        children++;
      }
    }

    if(par == -1 && children > 1) {
      ap[curr] = true;
    }
  }

  public static void getAP(ArrayList<Edge> graph[], int v) {
    int dt[] = new int[v];
    int low[] = new int[v];
    int time =0;
    boolean visited[] = new boolean[v];
    boolean ap[] = new boolean[v];
    
    for(int i=0; i<v; i++) {
      if(!visited[i]) {
        dfs3(graph, i, -1, dt, low, time, visited, ap);
      }
    }

    for(int i=0; i<v; i++) {
      if(ap[i]) {
        System.out.println("AP: "  + i);
    }
  }
}
  public static void main(String[] args) {
    // // strongly connected components - Kosaraju's Algorithm
    // // O(V+E)
    // int v =5;
    // ArrayList<Edge> graph[] = new ArrayList[v];
    // createGraph(graph);

    // kosaraju(graph, v);







    // // Bridge in graph (Tarjan's algorithm)
    // // O(V + E)
    // int v =6;
    // ArrayList<Edge> graph[] = new ArrayList[v];
    // createGraph(graph);
    // tarjanBridge(graph, v);




    // // Articulation point (Tarjan's algorithm)
    // // // O(V + E)
    // int v =5;

    // ArrayList<Edge> graph[] = new ArrayList[v];
    // createGraph(graph); 
    // getAP(graph, v);



  }
}
