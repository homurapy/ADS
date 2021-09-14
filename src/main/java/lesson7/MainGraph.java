package lesson7;

import java.util.ArrayList;
import java.util.List;

public class MainGraph {
    public static void main (String[] args) {
        List<String> cities = new ArrayList<>();
        cities = List.of("С-Пб", "Псков", "Новгород", "Тверь", "Москва", "Тула", "Смоленск", "Воронеж", "Казань", "Ярославль");
        GraphImpl c = createGraph(cities);
System.out.println(c.findShotDistance("С-Пб", "Смоленск"));



    }

    public static GraphImpl createGraph (List<String> cities) {
        GraphImpl graph = new GraphImpl(cities.size());
        cities.forEach(t -> graph.addVertex(t));
//С-Пб
        graph.addEdge(cities.get(0), cities.get(1), 300);
        graph.addEdge(cities.get(0), cities.get(2), 180);
//Псков
        graph.addEdge(cities.get(1), cities.get(0), 300);
        graph.addEdge(cities.get(1), cities.get(2), 150);
        graph.addEdge(cities.get(1), cities.get(6), 600);
//Новгород
        graph.addEdge(cities.get(2), cities.get(0), 180);
        graph.addEdge(cities.get(2), cities.get(1), 150);
        graph.addEdge(cities.get(2), cities.get(3), 350);
//Тверь
        graph.addEdge(cities.get(3), cities.get(2), 350);
        graph.addEdge(cities.get(3), cities.get(4), 180);
        graph.addEdge(cities.get(3), cities.get(6), 400);
//        graph.addEdge(cities.get(3), cities.get(9), 200);
//Москва
        graph.addEdge(cities.get(4), cities.get(3), 180);
        graph.addEdge(cities.get(4), cities.get(5), 100);
        graph.addEdge(cities.get(4), cities.get(6), 350);
//        graph.addEdge(cities.get(4), cities.get(7), 450);
//        graph.addEdge(cities.get(4), cities.get(8), 600);
//        graph.addEdge(cities.get(4), cities.get(9), 200);
////Тула
        graph.addEdge(cities.get(5), cities.get(4), 100);
        graph.addEdge(cities.get(5), cities.get(6), 380);
//        graph.addEdge(cities.get(5), cities.get(7), 200);
//        graph.addEdge(cities.get(5), cities.get(8), 750);
////Смоленск
        graph.addEdge(cities.get(6), cities.get(4), 350);
        graph.addEdge(cities.get(6), cities.get(5), 380);
//        graph.addEdge(cities.get(6), cities.get(7), 800);
        graph.addEdge(cities.get(6), cities.get(1), 600);
////Воронеж
//        graph.addEdge(cities.get(7), cities.get(4), 450);
//        graph.addEdge(cities.get(7), cities.get(5), 200);
//        graph.addEdge(cities.get(7), cities.get(6), 800);
//        graph.addEdge(cities.get(7), cities.get(8), 700);
////Казань
//        graph.addEdge(cities.get(8), cities.get(4), 600);
//        graph.addEdge(cities.get(8), cities.get(5), 750);
//        graph.addEdge(cities.get(8), cities.get(7), 700);
//        graph.addEdge(cities.get(8), cities.get(9), 500);
////Ярославль
//        graph.addEdge(cities.get(9), cities.get(3), 200);
//        graph.addEdge(cities.get(9), cities.get(4), 200);
//        graph.addEdge(cities.get(9), cities.get(8), 500);
//
        return graph;
    }
}


