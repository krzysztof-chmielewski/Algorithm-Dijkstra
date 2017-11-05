package com.kchmielewski.algorithm.dijkstra.core;

import com.kchmielewski.algorithm.dijkstra.structure.Edge;
import com.kchmielewski.algorithm.dijkstra.structure.Graph;
import com.kchmielewski.algorithm.dijkstra.structure.Vertex;

import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {
    public <T> Optional<Result> calculate(Graph<T> graph, Vertex<T> from, Vertex<T> to) {
        Set<Vertex<T>> vertices = new HashSet<>(graph.vertices());
        vertices.stream().filter(v -> v != from).forEach(v -> v.value(Float.MAX_VALUE));
        from.value(0);

        Queue<Vertex<T>> queue = new PriorityQueue<>(vertices);
        Map<Vertex<T>, List<Vertex<T>>> roads = vertices.stream().collect(Collectors.toMap(v -> v, v -> {
            List<Vertex<T>> list = new ArrayList<>();
            list.add(v);
            return list;
        }));

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.remove();
            for (Edge<T> edge : current.edges()) {
                Vertex<T> neighbour = edge.other(current);
                float newValue = current.value() + edge.value();
                if (newValue < neighbour.value()) {
                    List<Vertex<T>> newRoad = new ArrayList<>(roads.get(current));
                    newRoad.add(neighbour);
                    roads.put(neighbour, newRoad);
                    neighbour.value(newValue);
                    queue.remove(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        if (to.value() == Float.MAX_VALUE) {
            return Optional.empty();
        }

        return Optional.of(new Result<>(to.value(), roads.get(to)));
    }

    public static class Result<T> {
        private final float distance;
        private final List<Vertex<T>> road;

        private Result(float distance, List<Vertex<T>> road) {
            this.distance = distance;
            this.road = road;
        }

        public float distance() {
            return distance;
        }

        public List<Vertex<T>> road() {
            return road;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "distance=" + distance +
                    ", road=" + road +
                    '}';
        }
    }
}
