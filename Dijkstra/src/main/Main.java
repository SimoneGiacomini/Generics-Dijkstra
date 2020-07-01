package main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import dijkstra.DijkstraGraph;
import dijkstra.DijkstraNode;



public class Main {

	public static void main(String[] args) {
		
		MyNode a= new MyNode(0);
		a.addLink(1);
		a.addLink(2);
		MyNode b= new MyNode(1);
		b.addLink(2);
		b.addLink(3);
		MyNode c= new MyNode(3);
		c.addLink(2);
		MyNode d= new MyNode(2);
		
		Collection<MyNode> nodes= new ArrayList<MyNode>();
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);
		DijkstraGraph<Integer> graph= new DijkstraGraph(nodes);
	System.out.println(	graph.calculateBestPath(a, c)	);
	}
	
}
class MyNode extends DijkstraNode<Integer>{

	private double X;
	private double Y;
	
	
	
	MyNode(Integer name, Set<Integer> nodesIdsLink) {
		super(name, nodesIdsLink);
	
	}
	
	MyNode(Integer name){
		super(name);
	}

	@Override
	public double distance(DijkstraNode<Integer> otherNode) {
		
		if(otherNode instanceof MyNode) {
			MyNode newNode=(MyNode)otherNode;
			return Math.sqrt(Math.pow(X-newNode.X, 2)+Math.pow(Y-newNode.Y,2));
		}
		return -1;
	}
	
}
