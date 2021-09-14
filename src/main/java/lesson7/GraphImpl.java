package lesson7;


import java.util.*;
import java.util.stream.Collectors;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;

    public GraphImpl (int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex (String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge (String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }
        return result;
    }

    public boolean addEdge (String startLabel, String endLabel, Integer distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = distance;
        return true;
    }

    private int indexOf (String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize () {
        return vertexList.size();
    }

    @Override
    public void display () {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != null) {
                    System.out.println(" -> " + vertexList.get(j) + " " + adjMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs (String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private void visitVertex (Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex (Queue<Vertex> stack, Vertex vertex) {
//        System.out.println(vertex.getLabel());
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNearUnvisitedVertex (Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != null && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    @Override
    public void bfs (String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
    }

    private Vertex getNearUnvisitedVertexLevel (Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != null && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    public List<Vertex> findShotDistance (String start, String end) {
        int minDistance = 1000000;
        int startIndex = indexOf(start);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + start);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null ) {
                visitVertex(stack, vertex);
            } else {
                break;
            }
        }
        List<Vertex> temp = stack.stream().collect(Collectors.toList());
        makeUnVisited(temp);
        System.out.println("Start point " + temp.get(0));
        System.out.println("Stack "+ temp);
        List<Vertex> route = new ArrayList<>();
        for (int i = 1; i < temp.size(); i++) {
            List<Vertex> tempRoute = new ArrayList<>();
            tempRoute.add(vertexList.get(startIndex));
            tempRoute.add(temp.get(i));
            if (!temp.get(i).getLabel().equals(end)) {
                vertexList.get(indexOf(end)).setVisited(false);
                tempRoute.addAll(findShotDistance(temp.get(i).getLabel(), end));
                System.out.println("Route "+ tempRoute);

            }
            if (calcDistance(tempRoute) <= minDistance) {
                minDistance = calcDistance(tempRoute);
                System.out.println("Distance "+ minDistance);
                route.clear();
                route.addAll(tempRoute);
                makeUnVisited(vertexList);
                vertexList.get(i).setVisited(true);

            }

        }

        return route;
    }

    private int calcDistance (List<Vertex> route) {
        int distance = 0;

        for (int i = 0; i < route.size() - 1; i++) {
            if (adjMatrix[indexOf(route.get(i).getLabel())][indexOf(route.get(i + 1).getLabel())] != null) {
                distance += adjMatrix[indexOf(route.get(i).getLabel())][indexOf(route.get(i + 1).getLabel())];
            }
        }
        return distance;
    }
    private void makeUnVisited(List<Vertex> vertexList){
        for (int i = 1; i < vertexList.size(); i++) {
            vertexList.get(i).setVisited(false);
        }
    }
}
