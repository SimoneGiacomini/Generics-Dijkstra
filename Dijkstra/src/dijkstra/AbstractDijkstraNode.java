package dijkstra;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

abstract class AbstractDijkstraNode<K extends Comparable<? super K>> {

	private K id;

	private List<AbstractDijkstraNode<K>> shortestPath = new LinkedList<>();

	private Double distance = (double) Integer.MAX_VALUE;

	private Map<AbstractDijkstraNode<K>, Double> adjacentNodes = new HashMap<>();

	protected void addDestination(AbstractDijkstraNode<K> destination, Double distance) {
		adjacentNodes.put(destination, distance);
	}

	protected AbstractDijkstraNode(K name) {
		this.id = name;
	}

	public K getId() {

		return id;
	}

	protected void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDistance() {
		return distance;
	}

	public List<AbstractDijkstraNode<K>> getShortestPath() {
		return shortestPath;
	}

	protected void setShortestPath(List<AbstractDijkstraNode<K>> shortestPath) {
		this.shortestPath = shortestPath;
	}

	/**
	 * @return the adjacentNodes
	 */
	protected Map<AbstractDijkstraNode<K>, Double> getAdjacentNodes() {
		return adjacentNodes;
	}

	public int hashCode() {
		return id.hashCode();
	}

	public boolean equals(Object other) {

		if (other instanceof AbstractDijkstraNode) {
			AbstractDijkstraNode<K> node = (AbstractDijkstraNode<K>) other;
			return id == node.id;
		}

		return false;
	}

	public String toString () {
		return id.toString();
	}
	
	protected abstract double  distance(AbstractDijkstraNode<K> otherNode) ;
}

// public Graph(Collection<Node<K>> nodes) {
// for (Node<K> node : nodes) {
// this.nodes.put(node.getId(),node);
// }
//
// }
