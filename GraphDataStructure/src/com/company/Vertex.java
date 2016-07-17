package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun on 5/14/16.
 */
public class Vertex<T> {
    private long id;
    private T data;
    private List<Edge<T>> edges;
    private List<Vertex<T>> adjacentVertex;

    public Vertex(long id) {
        this.id = id;
        edges = new ArrayList<>();
        adjacentVertex = new ArrayList<>();
    }

    public long getId(){
        return id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex){
        edges.add(edge);
        adjacentVertex.add(vertex);
    }

    public List<Edge<T>> getEdges(){
        return edges;
    }

    public List<Vertex<T>> getAdjacentVertex(){
        return adjacentVertex;
    }

    public int getDegree(){
        return edges.size();
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}
