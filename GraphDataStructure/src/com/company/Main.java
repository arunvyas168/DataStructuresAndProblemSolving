package com.company;

import java.util.*;


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
        graph2.addEdge(1, 3);
        graph2.addEdge(1, 2);
        graph2.addEdge(3, 4);
        graph2.addEdge(5, 6);
        graph2.addEdge(6, 3);
        graph2.addEdge(3, 8);
        graph2.addEdge(8, 11);
        System.out.print("Result of topologically sorted graph is: { ");
        Stack<Long> TopoSortedGraph = TopologicalSort(graph2);
        for (long i : TopoSortedGraph){
            System.out.print(i+" ");
        }
        System.out.println("}");
    }

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
}