// import java.util.*;

public class Graphs5 {
//   static class Edge {
//     int src;
//     int dest; 
//     int wt;

//     public Edge(int s, int d, int w) {
//       this.src = s;
//       this.dest = d;
//       this.wt = w;
//     }
//   }


//   public static void createGraph(int flights[][],  ArrayList<Edge> graph[]) {
//     for(int i=0; i<graph.length; i++) {
//       graph[i] = new ArrayList<>();
//     }

//     for(int i=0; i<flights.length; i++) {
//       int src = flights[i][0];
//       int dest = flights[i][1];
//       int wt = flights[i][2];

//       Edge e = new Edge(src, dest, wt);
//       graph[src].add(e);
//     }
//   }

//   static class Info {
//     int v; // vertex
//     int cost;
//     int stops;

//     public Info(int v, int c, int s) {
//       this.v = v;
//       this.cost = c;
//       this.stops = s;
//     }
//   }

//   public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
//     ArrayList<Edge> graph[] = new ArrayList[n];
//     createGraph(flights, graph);

//     int dist[] = new int[n];
//     for(int i=0; i<n; i++) {
//       if(i != src) {
//         dist[i] = Integer.MAX_VALUE;
//       }
//     }

//     Queue<Info> q = new LinkedList<>();
//     q.add(new Info(src, 0, 0));

//     while(!q.isEmpty()) {
//       Info curr = q.remove();
//       if(curr.stops > k) {
//         break;
//       }

//       for(int i=0; i<graph[curr.v].size(); i++) {
//         Edge e = graph[curr.v].get(i);
//         int u = e.src;
//         int v = e.dest;
//         int wt = e.wt;

//         if(curr.cost + wt < dist[v] && curr.stops<=k) {
//           dist[v] = curr.cost + wt;
//           q.add(new Info(v, dist[v], curr.stops+1));
//         }
//       }
//     }
//     // dist[dest]
//     if(dist[dest] == Integer.MAX_VALUE) {
//       return -1; 
//     } else {
//       return dist[dest];
//     }
//   }





//   // connecting cities
//   static class Edge2 implements Comparable<Edge2> {
//     int dest;
//     int cost;

//     public Edge2 (int d, int c) {
//       this.dest = d;
//       this.cost = c;
//     }

//     @Override
//     public int compareTo(Edge2 e2) {
//       return this.cost - e2.cost;
//     }
//   }






//   public static int connectCities(int cities[][]) {
//     PriorityQueue<Edge2> pq = new PriorityQueue<>();
//     boolean visit[] = new boolean[cities.length];

//     pq.add(new Edge2(0, 0));
//     int finalCost = 0;

//     while(!pq.isEmpty()) {
//       Edge2 curr = pq.remove();
//       if(!visit[curr.dest]) {
//         visit[curr.dest] = true;
//         finalCost += curr.cost;
        
//         for(int i=0; i<cities[curr.dest].length; i++) {
//           if(cities[curr.dest][i] != 0) {
//             pq.add(new Edge2(i, cities[curr.dest][i]));
//           }
//         }
//       }
//     }

//     return finalCost;
//   }







//     // disjoint set DS
//     static int n=7;
//     static int par[] = new int[n];
//     static int rank[] = new int[n];
  
//     public static void init() {
//       for(int i=0; i<n;i++) {
//         par[i] = i;
//       }
//     }
  
//     public static int find(int x) {
//       if(x == par[x]) {
//         return x;
//       }
//       return par[x] = find(par[x]);
//     }

//     public static void union(int a , int b) {
//       int parA = find(a);
//       int parB = find(b);

//       if(rank[parA] == rank[parB]) {
//         par[parB] = parA;
//         rank[parA]++;
//       }  else if(rank[parA] < rank[parB]) {
//         par[parA] = parB;
//       } else{
//         par[parB] = parA;
//       }
//     }






  //   // Kruskal's algo
  //   static class Edge3 implements Comparable<Edge3> {
  //     int src;
  //     int dest; 
  //     int wt;
  
  //     public Edge3(int s, int d, int w) {
  //       this.src = s;
  //       this.dest = d;
  //       this.wt = w;
  //     }

  //     @Override
  //     public int compareTo(Edge3 e2) {
  //       return this.wt - e2.wt;
  //     }
  //   }  

  // static void createGraph3(ArrayList<Edge3> edges) {
  //   edges.add(new Edge3(0, 1, 10));
  //   edges.add(new Edge3(0, 2, 15));
  //   edges.add(new Edge3(0, 3, 30));
  //   edges.add(new Edge3(1, 3, 40));
  //   edges.add(new Edge3(2, 3, 50));
  // }

  // static int m=4;
  // static int parent[] = new int[m];
  // static int ranking[] = new int[m];

  // public static void initialize() {
  //   for(int i=0; i<m; i++) {
  //     parent[i] = i;
  //   }
  // }

  // public static int finding(int x) {
  //   if(parent[x] == x) {
  //     return x;
  //   }
  //   return parent[x] = finding(parent[x]);
  // }

  // public static void union3(int a , int b) {
  //   int parentA = finding(a);
  //   int parentB = finding(b);

  //   if(ranking[parentA] == ranking[parentB]) {
  //     parent[parentB] = parentA;
  //     ranking[parentA]++;
  //   }  else if(ranking[parentA] < ranking[parentB]) {
  //     parent[parentA] = parentB;
  //   } else{
  //     parent[parentB] = parentA;
  //   }
  // }
  

  // public static void kruskalsMST(ArrayList<Edge3> edges, int v) {
  //   initialize();
  //   Collections.sort(edges); // O(ElogE)
  //   int mstCost = 0;
  //   int count = 0;

  //   for(int i=0; count<v-1; i++) { // O(V)
  //     Edge3 e = edges.get(i);
  //     int parentA = finding(e.src); // src = a
  //     int parentB = finding(e.dest); //  dest = b
  //     if(parentA != parentB) {
  //       union3(e.src, e.dest);
  //       mstCost += e.wt;
  //       count++;
  //     }
  //   }
  //   System.out.println(mstCost);
  // }

  






    // Flood fill algorithm 
    // time complextity - O(n*n) {rows*cols}
  public void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int originalColor) {
    if(sr<0 || sc<0 || sr>=image.length || sc>=image.length || vis[sr][sc] || image[sr][sc] != originalColor) {
      return;
    }

    //left
    helper(image, sr, sc-1, color, vis, originalColor);

    // right
    helper(image, sr, sc+1, color, vis, originalColor);

    //up
    helper(image, sr-1, sc, color, vis, originalColor);

    //down
    helper(image, sr+1, sc, color, vis, originalColor);

  }
  
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean vis[][] = new boolean[image.length][image[0].length];
    helper(image, sr, sc, color, vis, image[sr][sc]);
    return image;
  }
  public static void main(String[] args) {
    
    // // cheapest flights with K stops
    // int n = 4;
    // int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
    // int src = 0, dst = 3, k =1;

    
    // System.out.println(cheapestFlight(n, flights, src, dst, k));

    



    // //connectng cities with min cost - using MST
    // int cities[][] = {{0, 1, 2, 3, 4},
    //                     {1, 0, 5, 0, 7},
    //                     {2, 5, 0, 6, 0},
    //                     {3, 0, 6, 0, 0},
    //                     {4, 7, 0, 0, 0}};

    // System.out.println(connectCities(cities));





    // // Disjoint Set DS
    // // union-find ki time complexity O(4k) ya O(4) isse constant bhi bol dete h

    // // path compression
    // init();
    // System.out.println(find(3));
    // union(1, 3);
    // System.out.println(find(3));
    // union(2, 4);
    // union(3, 6);
    // union(1, 4);
    // System.out.println(find(3));
    // System.out.println(find(4));
    // union(1, 5);










    // // Kruskal's algorithm - O(V + ElogE)
    // int v =4;
    // ArrayList<Edge3> edges = new ArrayList<>();
    // createGraph3(edges);
    // kruskalsMST(edges, v);




    
    // Flood fill algorithm






    // assignment

  }
}
