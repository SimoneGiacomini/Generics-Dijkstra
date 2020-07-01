package dijkstra;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

 class Dijkstra {

	 private Dijkstra() {}
	 
    protected static <K extends Comparable<? super K>> DijkstraGraph<K> calculateShortestPathFromSource(DijkstraGraph<K> graph, AbstractDijkstraNode<K> source) {

    	if(graph.getSpecificNode(source.getId())==null)
    		throw new IllegalArgumentException("This graph dont'contains the source");
    		
        source.setDistance(0);

        Set<AbstractDijkstraNode<K>> settledNodes = new HashSet<>();
        Set<AbstractDijkstraNode<K>> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            AbstractDijkstraNode<K> currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
           
            for (Entry<AbstractDijkstraNode<K>, Double> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                AbstractDijkstraNode<K> adjacentNode = adjacencyPair.getKey();
                Double edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static <K extends Comparable<? super K>> void CalculateMinimumDistance(AbstractDijkstraNode<K> evaluationNode, Double edgeWeigh, AbstractDijkstraNode<K> sourceNode) {
      
    	Double sourceDistance = sourceNode.getDistance();
        
    	if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            List<AbstractDijkstraNode<K>> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static <K extends Comparable<? super K>> AbstractDijkstraNode<K> getLowestDistanceNode(Set<AbstractDijkstraNode<K>> unsettledNodes) {
        AbstractDijkstraNode<K> lowestDistanceNode = null;
        double lowestDistance = Integer.MAX_VALUE;
        for (AbstractDijkstraNode<K> node : unsettledNodes) {
            double nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    

    
}
