package com.kchmielewski.algorithm.dijkstra.example;

import com.kchmielewski.algorithm.dijkstra.structure.Vertex;

public class Main {
    public static void main(String[] args) {
        Vertex<String> wroclaw = new Vertex<>("Wroclaw");
        Vertex<String> lodz = new Vertex<>("Lodz");
        Vertex<String> warszawa = new Vertex<>("Warszawa");

        wroclaw.link(lodz, 100);
        lodz.link(warszawa, 100);

        Vertex<String> iHopeThatVertexIsLodz = wroclaw.edges().get(0).other(wroclaw);
        Vertex<String> prayItIsWarszawa = iHopeThatVertexIsLodz.edges().get(1).other(iHopeThatVertexIsLodz);

        System.out.println(prayItIsWarszawa);
    }
}
