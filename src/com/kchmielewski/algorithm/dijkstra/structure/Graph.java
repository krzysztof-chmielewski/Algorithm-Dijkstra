package com.kchmielewski.algorithm.dijkstra.structure;

import java.util.List;

public class Graph<T> {
    private final List<Vertex<T>> vertices;

    public Graph(List<Vertex<T>> vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("Vertices cannot be null");
        }
        this.vertices = vertices;
    }

    public List<Vertex<T>> vertices() {
        return vertices;
    }

    @Override
    public String toString() {
        return "Graph" + vertices + '}';
    }
}
