package dev.koushik;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import junit.framework.TestCase;

/**
 * @author Koushik
 *
 */
public class TreeKNeighbourTest extends TestCase {
	public void testNull() {
		TreeKNeighbour neighbour = new TreeKNeighbour();

		Node secondLeftLeft = new Node(null, null, null, 33);
		Node secondLeftRight = new Node(null, null, null, 38);

		Node secondRightLeft = new Node(null, null, null, 43);
		Node secondRightRight = new Node(null, null, null, 48);

		Node firstLevelLeft = new Node(null, secondLeftLeft, secondLeftRight, 3);
		Node firstLevelRight = new Node(null, secondRightLeft, secondRightRight, 4);
		Node rootNode = new Node(null, firstLevelLeft, firstLevelRight, 0);

		Set<Node> nodeSet = neighbour.getKNeighbour(firstLevelRight, 2);
		assertNotNull(nodeSet);
		assertEquals(5, nodeSet.size());
		Set<Integer> valuesInSet = nodeSet.stream().map(Node::getData).collect(Collectors.toSet());
		Set<Integer> expectedValuesSet = new HashSet<Integer>(Arrays.asList(new Integer[] {48,0,3,4,43}));
		assertTrue(valuesInSet.containsAll(expectedValuesSet));
		
		nodeSet = neighbour.getKNeighbour(rootNode, 2);
		assertNotNull(nodeSet);
		assertEquals(7, nodeSet.size());
		valuesInSet = nodeSet.stream().map(Node::getData).collect(Collectors.toSet());
		expectedValuesSet = new HashSet<Integer>(Arrays.asList(new Integer[] {48,0,3,4,43,33,38}));
		assertTrue(valuesInSet.containsAll(expectedValuesSet));
		
		nodeSet = neighbour.getKNeighbour(secondLeftLeft, 2);
		assertNotNull(nodeSet);
		assertEquals(4, nodeSet.size());
		valuesInSet = nodeSet.stream().map(Node::getData).collect(Collectors.toSet());
		expectedValuesSet = new HashSet<Integer>(Arrays.asList(new Integer[] {0,3,33,38}));
		assertTrue(valuesInSet.containsAll(expectedValuesSet));
		
		nodeSet = neighbour.getKNeighbour(secondLeftRight, 2);
		assertNotNull(nodeSet);
		assertEquals(4, nodeSet.size());
		valuesInSet = nodeSet.stream().map(Node::getData).collect(Collectors.toSet());
		expectedValuesSet = new HashSet<Integer>(Arrays.asList(new Integer[] {0,3,33,38}));
		assertTrue(valuesInSet.containsAll(expectedValuesSet));
		
		nodeSet = neighbour.getKNeighbour(firstLevelLeft, 2);
		assertNotNull(nodeSet);
		assertEquals(5, nodeSet.size());
		valuesInSet = nodeSet.stream().map(Node::getData).collect(Collectors.toSet());
		expectedValuesSet = new HashSet<Integer>(Arrays.asList(new Integer[] {0,3,4,33,38}));
		assertTrue(valuesInSet.containsAll(expectedValuesSet));
	}
}
