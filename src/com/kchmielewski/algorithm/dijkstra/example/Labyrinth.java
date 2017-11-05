package com.kchmielewski.algorithm.dijkstra.example;

import com.kchmielewski.algorithm.dijkstra.core.Dijkstra;
import com.kchmielewski.algorithm.dijkstra.structure.Graph;
import com.kchmielewski.algorithm.dijkstra.structure.Vertex;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Labyrinth {

    public static void main(String[] args) throws IOException {
        String imageName = "resources/labyrinth.png";
        String resultImageName = "resources/labyrinthResult.png";
        BufferedImage image = ImageIO.read(new File(imageName));
        List<List<Vertex<Point>>> vertices = convertImageToPointGraph(image);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Vertex<Point> current = vertices.get(x).get(y);
                if (current != null) {
                    List<Vertex<Point>> surroundingVertices = findSurroundingVertices(vertices, x, y);
                    surroundingVertices.stream().filter(v -> !v.alreadyLinked(current)).forEach(v -> v.link(current, 1));
                }

            }
        }

        Graph<Point> labyrinth = new Graph<>(vertices.stream().flatMap(List::stream).filter(Objects::nonNull).collect(Collectors.toList()));
        Optional<Dijkstra.Result<Point>> result = new Dijkstra().calculate(labyrinth, vertices.get(0).get(0),
                vertices.get(vertices.size() - 1).get(vertices.get(0).size() - 1));
        if (result.isPresent()) {
            drawPath(result.get(), imageName, resultImageName);
        }
    }

    private static List<List<Vertex<Point>>> convertImageToPointGraph(BufferedImage image) {
        List<List<Vertex<Point>>> vertices = new ArrayList<>(image.getWidth());
        int white = Color.WHITE.getRGB();
        for (int x = 0; x < image.getWidth(); x++) {
            vertices.add(new ArrayList<>(image.getHeight()));
            for (int y = 0; y < image.getHeight(); y++) {
                if (image.getRGB(x, y) == white) {
                    vertices.get(x).add(y, new Vertex<>(new Point(x, y)));
                } else {
                    vertices.get(x).add(y, null);
                }
            }
        }

        return vertices;
    }

    private static void drawPath(Dijkstra.Result<Point> result, String fileName, String newFileName) throws IOException {
        BufferedImage image = ImageIO.read(new File(fileName));
        int color = Color.green.getRGB();
        result.road().forEach(v -> image.setRGB(v.name().x, v.name().y, color));
        ImageIO.write(image, "png", new File(newFileName));
    }

    private static <T> List<Vertex<T>> findSurroundingVertices(List<List<Vertex<T>>> vertices, int x, int y) {
        List<Vertex<T>> result = new ArrayList<>(8);
        for (int i = x - 1; i < x + 1; i++) {
            for (int j = y - 1; j < y + 1; j++) {
                if ((x > 0 && x < vertices.size() && y > 0 && y < vertices.get(0).size()) && (i != x || j != y)) {
                    Vertex<T> foundVertex = vertices.get(i).get(j);
                    if (foundVertex != null) {
                        result.add(foundVertex);
                    }
                }
            }
        }

        return result;
    }
}