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

    public Vertex<T> other(Vertex<T> given) {
        if (vertices.get(0) == given) {
            return vertices.get(1);
        } else if (vertices.get(1) == given) {
            return vertices.get(0);
        } else {
            throw new IllegalArgumentException("Called #other method with Vertex that do not belongs to the edge.");
        }
    }
}
