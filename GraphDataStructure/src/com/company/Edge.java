package com.company;

/**
 * Created by arun on 5/14/16.
 */
public class Edge<T> {
    private boolean isDirected;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    public Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Edge(boolean isDirected, Vertex<T> vertex1, Vertex<T> vertex2, int weight) {
        this.isDirected = isDirected;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }


    public Edge(boolean isDirected, Vertex<T> vertex1, Vertex<T> vertex2) {
        this.isDirected = isDirected;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public Vertex<T> getVertex1() {
        return this.vertex1;
    }

    public Vertex<T> getVertex2() {
        return this.vertex2;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }
}
