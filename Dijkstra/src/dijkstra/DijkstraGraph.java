package dijkstra;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
 
public class DijkstraGraph<K extends Comparable<? super K>> {

	private Map<K, DijkstraNode<K>> abstractDijkstraNodes = new HashMap<>();

	public void addNode(DijkstraNode<K> nodeA) {

		abstractDijkstraNodes.put(nodeA.getId(), nodeA);

	}

	public Collection<DijkstraNode<K>> getGraph() {
		return abstractDijkstraNodes.values();
	}

	public DijkstraNode<K> getSpecificNode(K id) {

		return abstractDijkstraNodes.get(id);
	}

	public DijkstraGraph(Collection<DijkstraNode<K>> nodes) {
		// take all nodes & put all in the grah w/out the distance
		for (DijkstraNode<K> node : nodes) {
			this.abstractDijkstraNodes.put(node.getId(), node);
		}
		// for every nodes in the graph
		for (Iterator iterator = abstractDijkstraNodes.values().iterator(); iterator.hasNext();) {

			DijkstraNode<K> dijkstraNode = (DijkstraNode<K>) iterator.next();
			// know how r his link nodes
			Collection<K> linkNodes = dijkstraNode.nodesIdsLink;

			// for every nodes linked to dijkstraNode
			for (Iterator iterator2 = linkNodes.iterator(); iterator2.hasNext();) {

				K k = (K) iterator2.next();
				// take the specific Node from the graph
				DijkstraNode<K> linkNode = abstractDijkstraNodes.get(k);
				// attached him to the dijkstraNode & calc his distance from him
				dijkstraNode.addDestination(linkNode, dijkstraNode.distance(linkNode));

			}
		}
	}

	public Collection<AbstractDijkstraNode<K>> calculateBestPath(DijkstraNode<K> source, DijkstraNode<K> finish) {
		Dijkstra.calculateShortestPathFromSource(this, source);
		return finish.getShortestPath();

	}
}
