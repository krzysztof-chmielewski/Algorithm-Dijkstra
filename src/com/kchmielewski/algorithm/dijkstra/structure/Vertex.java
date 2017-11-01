package com.kchmielewski.algorithm.dijkstra.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex<T> implements Comparable<Vertex<T>> {
    private final T name;
    private final List<Edge<T>> edges = new ArrayList<>();
    private float value;

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

    public void value(float value) {
        this.value = value;
    }

    public float value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        return name != null ? name.equals(vertex.name) : vertex.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int compareTo(Vertex<T> o) {
        return Float.compare(value, o.value);
    }
}
