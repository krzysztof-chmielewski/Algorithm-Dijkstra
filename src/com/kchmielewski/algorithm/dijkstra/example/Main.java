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
        Map<String, Vertex<String>> cities = readCitiesFromFile("resources/cities.txt");
        Graph<String> graph = new Graph<>(new ArrayList<>(cities.values()));
        Dijkstra dijkstra = new Dijkstra();

        System.out.println("Distance from Krakow to Gdansk is: ");
        System.out.println(dijkstra.calculate(graph, cities.get("Krakow"), cities.get("Gdansk")));
        System.out.println("Distance from Gdansk to Krakow is: ");
        System.out.println(dijkstra.calculate(graph, cities.get("Gdansk"), cities.get("Krakow")));
        System.out.println("Distance from New York to Boston is: ");
        System.out.println(dijkstra.calculate(graph, cities.get("New York"), cities.get("Boston")));
        System.out.println("Distance from New York to Poznan is: ");
        System.out.println(dijkstra.calculate(graph, cities.get("New York"), cities.get("Poznan")));
    }

    private static Map<String, Vertex<String>> readCitiesFromFile(String fileName) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(fileName + " does not exist. Exiting.");
            e.printStackTrace();
            System.exit(0);
        }
        Map<String, Vertex<String>> cities = new HashMap<>();

        lines.forEach(l -> {
            Scanner scanner = new Scanner(l);
            scanner.useDelimiter(";");
            String firstCityName = scanner.next();
            String secondCityName = scanner.next();
            float distance = scanner.nextFloat();
            Vertex<String> firstCity = new Vertex<>(firstCityName);
            Vertex<String> secondCity = new Vertex<>(secondCityName);
            if (!cities.containsKey(firstCityName)) {
                cities.put(firstCityName, firstCity);
            }
            if (!cities.containsKey(secondCityName)) {
                cities.put(secondCityName, secondCity);
            }
            cities.get(firstCityName).link(cities.get(secondCityName), distance);
        });

        return cities;
    }
}
