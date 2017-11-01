package com.kchmielewski.algorithm.dijkstra.structure;

import java.util.List;

public class Edge<T> {
    private final List<Vertex<T>> vertices;
    private final float value;

    Edge(List<Vertex<T>> vertices, float value) {
        if (vertices.size() != 2) {
            throw new IllegalArgumentException("Edge must link exactly two vertices.");
        }
        if (vertices.get(0) == vertices.get(1)) {
            throw new IllegalArgumentException("Edge must link two different vertices.");
        }
        this.vertices = vertices;
        this.value = value;
    }

    public List<Vertex<T>> vertices() {
        return vertices;
    }

    public float value() {
        return value;
    }
}