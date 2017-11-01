package com.kchmielewski.algorithm.dijkstra.core;

import com.kchmielewski.algorithm.dijkstra.structure.Edge;
import com.kchmielewski.algorithm.dijkstra.structure.Graph;
import com.kchmielewski.algorithm.dijkstra.structure.Vertex;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Dijkstra {
    public <T> float calculate(Graph<T> graph, Vertex<T> from, Vertex<T> to) {
        Set<Vertex<T>> vertices = new HashSet<>(graph.vertices());
        vertices.stream().filter(v -> v != from).forEach(v -> v.value(Float.MAX_VALUE));
        from.value(0);

        Queue<Vertex<T>> queue = new PriorityQueue<>(vertices);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.remove();
            for (Edge<T> edge : current.edges()) {
                Vertex<T> neighbour = edge.other(current);
                float newValue = current.value() + edge.value();
                if (newValue < neighbour.value()) {
                    neighbour.value(newValue);
                    queue.remove(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        return to.value();
    }
}
