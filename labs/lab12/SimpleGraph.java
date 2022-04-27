/**
 This is a class derived and adapted from the textbook: DirectedGraph.java
 A class that implements the ADT directed graph.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 4.0
 */
import java.util.*;

public class SimpleGraph<T> implements GraphInterface<T> {
    private HashMap<T,  VertexInterface<T>> vertices;
    private int edgeCount;

    public SimpleGraph() {
        vertices = new HashMap<T, VertexInterface<T>>();
        edgeCount = 0;
    }

    @Override
    public boolean addVertex(T vertexLabel) {
        return null == vertices.put(vertexLabel, new Vertex<>(vertexLabel));
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        boolean result = false;

        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ( (beginVertex != null) && (endVertex != null) )
            result = beginVertex.connect(endVertex, edgeWeight);

        if (result)
            edgeCount++;

        return result;
    }

    @Override
    public boolean addEdge(T begin, T end) {
        return addEdge(begin, end, 0);
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        boolean found = false;

        VertexInterface<T> beginVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ( (beginVertex != null) && (endVertex != null) )
        {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
            while (!found && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (endVertex.equals(nextNeighbor))
                    found = true;
            } // end while
        } // end if

        return found;
    }

    @Override
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    public int getNumberOfVertices() {
        return vertices.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edgeCount;
    }

    @Override
    public void clear() {
        vertices.clear();
        edgeCount = 0;
    }

    @Override
    public VertexInterface<T> getVertex(T label) {
        return vertices.get(label);
    }

    private class VertexIterator implements Iterator<VertexInterface<T>> {
        private Iterator<Map.Entry<T, VertexInterface<T>>> verticeIterator;

        private VertexIterator() {
            verticeIterator = vertices.entrySet().iterator();
        } // end default constructor

        public boolean hasNext() {
            return verticeIterator.hasNext();
        } // end hasNext

        public  VertexInterface<T> next() {
            return verticeIterator.hasNext() ? vertices.get(verticeIterator.next().getValue().getLabel()) : null;
        } // end next
    }

    public VertexIterator getVertexIterator() {
        return new VertexIterator();
    }


    private void setAllVerticesUnvisited() { 
        Iterator<VertexInterface<T>> it = this.getVertexIterator();
        while (it.hasNext()) {
            VertexInterface<T> vi = it.next();
	        vi.unvisit();
	    }
    }


    @Override
    public Queue<VertexInterface<T>> getBreadthFirstTraversal(T origin) {
        //https://www.baeldung.com/java-breadth-first-search
        setAllVerticesUnvisited(); //resets state of all vertices to "unvisited"
        Queue<Vertex<T>> vertexQueue = new ArrayDeque<>();
        Queue<VertexInterface<T>> breadth = new PriorityQueue<>();
        vertexQueue.add((Vertex<T>) origin);
        while (! vertexQueue.isEmpty()) {
            Vertex<T> current = vertexQueue.remove(); //pop head
            Iterator<VertexInterface<T>> neighbor = current.getNeighborIterator(); //get neighbors
            while (neighbor.hasNext()) {
                VertexInterface<T> vertex = neighbor.next();
                breadth.add(vertex);
                vertex.visit(); //visits all vertexes
                vertexQueue.remove();
            }
        }
        return breadth;
    }


    @Override
    public Queue<VertexInterface<T>> getDepthFirstTraversal(T origin) {
        setAllVerticesUnvisited(); //resets state of all vertices to "unvisited"
        Stack<VertexInterface<T>> vertexStack = new Stack<>();
        Queue<VertexInterface<T>> traversal = new PriorityQueue<>();
        ArrayList<Integer> intlist = new ArrayList<Integer>();
        vertexStack.push(getVertex(origin));
        while (! vertexStack.isEmpty()) {
            VertexInterface<T> current = vertexStack.pop();
            edgeCount = 0;
            if (! current.isVisited()) {
                current.visit(); //visits vertices
                traversal.add(current);
                Iterator<VertexInterface<T>> iter = current.getNeighborIterator();
                while (iter.hasNext()) {
                    vertexStack.push(iter.next());
                    edgeCount++;
                }
                intlist.add(edgeCount);
            }
        }
        return traversal;
    }

    @Override
    public Map<T, Integer> measureDegrees() {
        Map<T, Integer> map = new HashMap<>();
        Map<T, Integer> degrees = new HashMap<>();
        Integer degree = 0; //TODO: how?
        T origin = map.getLabel();
        map.put(origin,degree);
        T current = null;
        while (! map.isEmpty()) {
            current = origin; //set current
            map.remove(origin); //remove from map
            degrees.put(current, map.get(current)); //add pair to degree measurement
            //TODO: how to count degrees?
        }
        return map;
    }
}

