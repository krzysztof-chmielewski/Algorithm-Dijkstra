package com.kchmielewski.algorithm.dijkstra.example;

import com.kchmielewski.algorithm.dijkstra.core.Dijkstra;
import com.kchmielewski.algorithm.dijkstra.structure.Graph;
import com.kchmielewski.algorithm.dijkstra.structure.Vertex;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vertex<String> wroclaw = new Vertex<>("Wroclaw");
        Vertex<String> katowice = new Vertex<>("Katowice");
        Vertex<String> lodz = new Vertex<>("Lodz");
        Vertex<String> warszawa = new Vertex<>("Warszawa");
        Vertex<String> poznan = new Vertex<>("Poznan");
        Vertex<String> krakow = new Vertex<>("Krakow");
        Vertex<String> gdansk = new Vertex<>("Gdansk");
        Vertex<String> gdynia = new Vertex<>("Gdynia");
        Vertex<String> newYork = new Vertex<>("New York");
        Vertex<String> boston = new Vertex<>("Boston");

        wroclaw.link(lodz, 216.8f);
        wroclaw.link(poznan, 184.4f);
        wroclaw.link(katowice, 194.5f);
        krakow.link(katowice, 80.36f);
        krakow.link(warszawa, 294.8f);
        krakow.link(lodz, 266.8f);
        lodz.link(warszawa, 139.1f);
        poznan.link(lodz, 217.8f);
        poznan.link(gdansk, 337.9f);
        lodz.link(gdansk, 336.9f);
        warszawa.link(gdansk, 417.4f);
        gdynia.link(gdansk, 22.4f);
        boston.link(newYork, 345.6f);

        Graph<String> cities = new Graph<>(Arrays.asList(wroclaw, katowice, lodz, warszawa, poznan, krakow, gdansk,
                gdynia, newYork, boston));

        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Distance from Krakow to Gdansk is: ");
        System.out.println(dijkstra.calculate(cities, krakow, gdansk));
        System.out.println("Distance from Gdansk to Krakow is: ");
        System.out.println(dijkstra.calculate(cities, gdansk, krakow));
        System.out.println("Distance from New York to Boston is: ");
        System.out.println(dijkstra.calculate(cities, newYork, boston));
        System.out.println("Distance from new York to Poznan is: ");
        System.out.println(dijkstra.calculate(cities, newYork, poznan));
    }
}
