package dijkstra;
import java.util.HashSet;
import java.util.Set;

public abstract class DijkstraNode<K extends Comparable<? super K>> extends AbstractDijkstraNode<K>{

	protected Set<K> nodesIdsLink= new HashSet<>();
	
	public DijkstraNode(K name, Set<K> nodesIdsLink) {
		super(name);
		this.nodesIdsLink=nodesIdsLink;
	}
	public DijkstraNode(K name) {
		super(name);
	}

	public boolean addLink(K linkId) {
		if(linkId.compareTo(this.getId())==0)
			return false;
		return nodesIdsLink.add(linkId);
	}
	
	public abstract double distance(DijkstraNode<K>otherNode);

	protected double distance (AbstractDijkstraNode<K> node) {
		return distance(node);
	}
}
