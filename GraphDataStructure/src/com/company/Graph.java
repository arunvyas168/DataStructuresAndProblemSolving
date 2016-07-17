package com.company;

import java.util.*;

/**
 * Created by arun on 5/14/16.
 */
public class Graph<T> {
    private List<Edge<T>> allEdges;
    private Map<Long,Vertex<T>> allVertex;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        allEdges = new ArrayList<>();
        allVertex = new HashMap<>();
    }

    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }

    public void addEdge(long id1, long id2, int weight){
        Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(isDirected,vertex1,vertex2,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }

    public void addVertex(Vertex<T> vertex){
        if(allVertex.containsKey(vertex.getId())){
            return;
        }else{
            allVertex.put(vertex.getId(),vertex);
            for (Edge<T> e : vertex.getEdges()){
                allEdges.add(e);
            }
        }
    }

    public Vertex<T> addSingleVertex(long id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }else {
            Vertex<T> vertex  = new Vertex<>(id);
            return vertex;
        }
    }

    public Vertex<T> getVertex(long id){
        return allVertex.get(id);
    }

    public Collection<Vertex<T>> getAllVertex(){
        return allVertex.values();
    }



}
