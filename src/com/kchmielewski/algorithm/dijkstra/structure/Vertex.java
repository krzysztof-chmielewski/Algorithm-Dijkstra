package com.kchmielewski.algorithm.dijkstra.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex<T> {
    private final T name;
    private final List<Edge<T>> edges = new ArrayList<>();

    public Vertex(T name) {
        this.name = name;
    }

    public void link(Vertex<T> other, float edgeValue) {
        Edge<T> edge = new Edge<>(Arrays.asList(this, other), edgeValue);
        edges.add(edge);
        other.edges.add(edge);
    }

    public T name() {
        return name;
    }

    public List<Edge<T>> edges() {
        return edges;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
