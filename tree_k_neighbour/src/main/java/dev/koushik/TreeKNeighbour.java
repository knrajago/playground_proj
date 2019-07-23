package dev.koushik;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Koushik
 *
 */
public class TreeKNeighbour {

	public TreeKNeighbour() {
	}

	private Node rootNode;
	
	private void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	public Set<Node> getKNeighbour(Node source, int k) {
		Set<Node> neighbourSet = null;
		if (source != null && k >= 0) {
			neighbourSet = new HashSet<Node>();
			Set<Node> neighboursOfNeighbours = getKNeighbourAvoidSrc(source, k, null);
			if (neighboursOfNeighbours != null) {
				neighbourSet.addAll(getKNeighbourAvoidSrc(source, k, null));
			}
		}
		return neighbourSet;
	}

	public Set<Node> getKNeighbourAvoidSrc(Node curNode, int k, Node fromNode) {
		Set<Node> neighbours = null;
		if (curNode != null && k >= 0) {
			neighbours = new HashSet<Node>();
			neighbours.add(curNode);
			if (k > 0) {
				if (fromNode == null) {
					if (curNode.getLeft() != null) {
						neighbours.addAll(getKNeighbourAvoidSrc(curNode.getLeft(), k - 1, curNode));
					}
					if (curNode.getRight() != null) {
						neighbours.addAll(getKNeighbourAvoidSrc(curNode.getRight(), k - 1, curNode));
					}
					if (curNode.getParent() != null) {
						neighbours.addAll(getKNeighbourAvoidSrc(curNode.getParent(), k - 1, curNode));
					}
				} else if (curNode.getParent() == fromNode) {
					// This node was reached from its parent. So, look for
					// its children - right and left.
					if (curNode.getRight() != null) {
						neighbours.addAll(getKNeighbourAvoidSrc(curNode.getRight(), k - 1, curNode));
					}
					if (curNode.getLeft() != null) {
						neighbours.addAll(getKNeighbourAvoidSrc(curNode.getLeft(), k - 1, curNode));
					}
				} else if (curNode.getLeft() == fromNode) {
					// This node was reached from its left child. So, look for
					// its parent and right child.
					if (curNode.getRight() != null) {
						neighbours.addAll(getKNeighbourAvoidSrc(curNode.getRight(), k - 1, curNode));
					}
					if (curNode.getParent() != null) {
						neighbours.addAll(getKNeighbourAvoidSrc(curNode.getParent(), k - 1, curNode));
					}
				} else if (curNode.getRight() == fromNode) {
					// This node was reached from its right child. So, look for
					// its parent and right child.
					if (curNode.getParent() != null) {
						neighbours.addAll(getKNeighbourAvoidSrc(curNode.getParent(), k - 1, curNode));
					}
					if (curNode.getLeft() != null) {
						neighbours.addAll(getKNeighbourAvoidSrc(curNode.getLeft(), k - 1, curNode));
					}
				}
			}
		}
		return neighbours;
	}
}
