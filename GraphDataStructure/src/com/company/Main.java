package com.company;

import java.util.*;

/**
 * List of problem solved in this program
 *          1. Basic Graph Datastructure
 *          2. DFS
 *          3. BFS
 *          4. Topological Sort
 *          5. Print All Path From Source To Destination using DFS
 *          6. Detect Cycle in a directed Graph
 */



public class Main {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        graph.addSingleVertex(1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,3);
        graph.addEdge(3,6);
        graph.addEdge(2,5);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        graph.addEdge(3,6);
        graph.addEdge(6,7);
        graph.addEdge(7,1);
        DFSGraphTraversal(graph);
        System.out.println();
        BFSGraphTraversal(graph);
        System.out.println();

    /**
     * Topological Sort
     */
        Graph<Integer> graph2 = new Graph<>(true);
        graph2.addEdge(1, 2);
        graph2.addEdge(4, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(2, 5);
        graph2.addEdge(5, 11);
        graph2.addEdge(11, 12);
        graph2.addEdge(5, 6);
        graph2.addEdge(3, 6);
        graph2.addEdge(8, 6);
        graph2.addEdge(8, 9);
        graph2.addEdge(8, 10);
        graph2.addEdge(6, 7);

        System.out.print("Result of topologically sorted graph is: { ");
        Stack<Long> TopoSortedGraph = TopologicalSort(graph2);
        for (long i : TopoSortedGraph){
            System.out.print(i+" ");
        }
        System.out.println("}");


        /**
         * Print All Path From Source To Destination
         */
        Vertex<Integer> start = graph2.getVertex(1);
        Vertex<Integer> end = graph2.getVertex(7);
        printPath(graph2,start,end);

        /**
         * Detect Cycle in a directed Graph
         */
        Graph<Integer> graph3 = new Graph<>(true);
        graph3.addEdge(1, 2);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 4);
        graph3.addEdge(4, 1);
        System.out.println("Does the graph has cycle: "+hasCycle(graph3));
        DFSGraphTraversal(graph3);
        System.out.println();
        int[][]graph3_matrix = {
                {0,1,0,1},
                {1,0,1,0},
                {0,1,0,1},
                {1,0,1,0}
        };
        DFSAdjacencyMatrix(graph3_matrix,0);
        System.out.println();

    }

    /**
     *  DFS Graph Traversal
     */
    public static void DFSGraphTraversal(Graph<Integer> graph){
        Set<Long> visited = new HashSet<>();
        for(Vertex<Integer> vertex: graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                DFSUtil(vertex,visited);
            }
        }
    }

    private static void DFSUtil(Vertex<Integer> vertex, Set<Long> visited){
        visited.add(vertex.getId());
        System.out.print(vertex.getId()+" ");
        for (Vertex<Integer> v: vertex.getAdjacentVertex()){
            if (!visited.contains(v.getId())){
                DFSUtil(v,visited);
            }
        }
    }


    /**
     *  BFS Graph Traversal
     */
    public static void BFSGraphTraversal(Graph<Integer> graph){
        HashSet<Long> set = new HashSet<>();
        Queue<Vertex<Integer>> queue = new LinkedList<>();
        for(Vertex<Integer> vertex : graph.getAllVertex()) {
            if (!set.contains(vertex.getId())) {
                queue.add(vertex);
                set.add(vertex.getId());
                while (queue.size() != 0) {
                    Vertex<Integer> v = queue.poll();
                    System.out.print(v.getId()+" ");
                    for (Vertex<Integer> adjVert : v.getAdjacentVertex()) {
                        if (!set.contains(adjVert.getId())){
                            set.add(adjVert.getId());
                            queue.add(adjVert);
                        }
                    }
                }
            }
        }
    }





    /**
     *  Topological Sort  or Dependency problem
     */
    public static Stack<Long> TopologicalSort(Graph<Integer> graph){
        HashSet<Long> set = new HashSet<>();
        Stack<Long> stack = new Stack<>();
        for (Vertex<Integer> vertex : graph.getAllVertex()){
            if (set.contains(vertex.getId())){
                continue;
            }
            TopologicalSort_util(vertex,set,stack);
        }
        return stack;
    }

    public static void TopologicalSort_util(Vertex<Integer> vertex, HashSet<Long> set,Stack<Long> stack){

        set.add(vertex.getId());
        for (Vertex<Integer> v : vertex.getAdjacentVertex()){
            if (set.contains(v.getId())){
                continue;
            }
            TopologicalSort_util(v,set,stack);
        }
        stack.push(vertex.getId());

    }


    /**
     *  Print All Path From Source To Destination using DFS
     */
    public static void printPath(Graph<Integer> graph2, Vertex<Integer> start, Vertex<Integer> end){
        Set<Vertex<Integer>> set = new HashSet<>();
        printPath_util(graph2,set,end,start);
    }

    public static void printPath_util(Graph<Integer> graph2, Set<Vertex<Integer>>set,
                                      Vertex<Integer> end, Vertex<Integer> current){


        if (set.contains(current)){
            return;
        }

        if (current.equals(end)){               //if there is a path from source to destination
            for(Vertex<Integer> v : set){
                System.out.print(v.getId()+" ");
            }
            System.out.println(end.getId());
            return;
        }
        set.add(current);

        for (Vertex<Integer> child : current.getAdjacentVertex()){
            printPath_util(graph2,set,end,child);
        }
        set.remove(current);  // very very important

    }


    /**
     * Detect Cycle in a directed Graph
     */

    public static boolean hasCycle(Graph<Integer> graph){
        HashSet<Vertex<Integer>> whiteSet = new HashSet<>();
        HashSet<Vertex<Integer>> graySet = new HashSet<>();
        HashSet<Vertex<Integer>> blackSet = new HashSet<>();
        for (Vertex<Integer> vertex : graph.getAllVertex()){
            whiteSet.add(vertex);
        }
        while (whiteSet.size()>0){
            Vertex<Integer> v = whiteSet.iterator().next();
            if(dfs_detectCycle(v,whiteSet,graySet,blackSet)){
                return true;
            }
        }
        return false;
    }

    public static boolean dfs_detectCycle(Vertex<Integer> current,HashSet<Vertex<Integer>> whiteSet,
                                          HashSet<Vertex<Integer>> graySet,
                                          HashSet<Vertex<Integer>> blackSet){

        moveVertex(current,whiteSet,graySet);

        for (Vertex<Integer> neighbour : current.getAdjacentVertex()){
            if (blackSet.contains(neighbour)){
                continue;
            }
            if (graySet.contains(neighbour)){
                return true;
            }
            if(dfs_detectCycle(neighbour,whiteSet,graySet,blackSet)){
                return true;
            }
        }

        moveVertex(current,graySet,blackSet);
        return false;
    }

    public static void moveVertex(Vertex<Integer> v, HashSet<Vertex<Integer>> source,
                                  HashSet<Vertex<Integer>> destination){
        source.remove(v);
        destination.add(v);
    }



    /**
     * DFS given Adjacency Matrix
     */

    public static void DFSAdjacencyMatrix(int[][] graph, int s){
        HashSet<Integer> set = new HashSet<>();
        System.out.print((s+1)+" ");
        set.add(s);
        for (int i=0;i<graph[s].length;i++){
            if ((graph[s][i]!=0)&&(!set.contains(i))){
                DFSAdjacencyMatrix_util(graph,i,set);
            }
        }
    }
    public static void DFSAdjacencyMatrix_util(int[][] graph, int s, HashSet<Integer> set){
        set.add(s);
        System.out.print(s+1+" ");
        for (int i=0;i<graph[s].length;i++){
            if ((graph[s][i]!=0)&&(!set.contains(i))){
                DFSAdjacencyMatrix_util(graph,i,set);
            }
        }
    }
}