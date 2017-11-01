package com.kchmielewski.algorithm.dijkstra.example;

import com.kchmielewski.algorithm.dijkstra.structure.Graph;
import com.kchmielewski.algorithm.dijkstra.structure.Vertex;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vertex<String> wroclaw = new Vertex<>("Wroclaw");
        Vertex<String> lodz = new Vertex<>("Lodz");
        Vertex<String> warszawa = new Vertex<>("Warszawa");

        Vertex<String> lasVegas = new Vertex<>("Las Vegas");
        Vertex<String> losAngeles = new Vertex<>("Los Angeles");

        wroclaw.link(lodz, 100);
        lodz.link(warszawa, 100);

        lasVegas.link(losAngeles, 500);

        Graph<String> cities = new Graph<>(Arrays.asList(wroclaw, lodz, warszawa, lasVegas, losAngeles));
        System.out.println(cities);
    }
}
