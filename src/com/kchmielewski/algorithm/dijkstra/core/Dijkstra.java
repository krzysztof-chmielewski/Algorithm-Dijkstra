package com.kchmielewski.algorithm.dijkstra.core;

import com.kchmielewski.algorithm.dijkstra.structure.Graph;
import com.kchmielewski.algorithm.dijkstra.structure.Vertex;

import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
    public <T> float calculate(Graph<T> graph, Vertex<T> from, Vertex<T> to) {
        Set<Vertex<T>> vertices = new HashSet<>(graph.vertices());
        vertices.stream().filter(v -> v != from).forEach(v -> v.value(Float.MAX_VALUE));
        from.value(0);

        return 0f;
    }
}
