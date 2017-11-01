package com.kchmielewski.algorithm.dijkstra.example;

import com.kchmielewski.algorithm.dijkstra.core.Dijkstra;
import com.kchmielewski.algorithm.dijkstra.structure.Graph;
import com.kchmielewski.algorithm.dijkstra.structure.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "resources/cities.txt";
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(fileName + " does not exist. Exiting.");
            e.printStackTrace();
            System.exit(0);
        }
        Map<Vertex<String>, Vertex<String>> cities = new HashMap<>();

        lines.forEach(l -> {
            String[] line = l.split(";");
            Vertex<String> firstCity = new Vertex<>(line[0]);
            Vertex<String> secondCity = new Vertex<>(line[1]);
            float distance = Float.parseFloat(line[2]);
            if (!cities.containsKey(firstCity)) {
                cities.put(firstCity, firstCity);
            }
            if (!cities.containsKey(secondCity)) {
                cities.put(secondCity, secondCity);
            }
            cities.get(firstCity).link(cities.get(secondCity), distance);
        });
        Graph<String> graph = new Graph<>(new ArrayList<>(cities.values()));
        Dijkstra dijkstra = new Dijkstra();

        System.out.println("Distance from Krakow to Gdansk is: ");
        System.out.println(dijkstra.calculate(graph,
                cities.get(new Vertex<>("Krakow")),
                cities.get(new Vertex<>("Gdansk"))));
        System.out.println("Distance from Gdansk to Krakow is: ");
        System.out.println(dijkstra.calculate(graph,
                cities.get(new Vertex<>("Gdansk")),
                cities.get(new Vertex<>("Krakow"))));
        System.out.println("Distance from New York to Boston is: ");
        System.out.println(dijkstra.calculate(graph,
                cities.get(new Vertex<>("New York")),
                cities.get(new Vertex<>("Boston"))));
        System.out.println("Distance from New York to Poznan is: ");
        System.out.println(dijkstra.calculate(graph,
                cities.get(new Vertex<>("New York")),
                cities.get(new Vertex<>("Poznan"))));
    }
}
