package dev.koushik;

/**
 * @author Koushik
 *
 */
public class Node {
	private Node parent;
	private Node left;
	private Node right;
	private int data;
	/**
	 * @param parent
	 * @param left
	 * @param right
	 * @param data
	 */
	public Node(Node parent, Node left, Node right, int data) {
		super();
		if (parent != null) {
			this.parent = parent;
		}
		if (left != null) {
			this.left = left;
			this.left.parent = this;
		}
		if (right != null) {
			this.right = right;
			this.right.parent = this;
		}
		
		this.data = data;
	}
	
	/**
	 * 
	 * @param data
	 */
	public Node(int data) {
		super();
		this.data = data;
	}
	
	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("    " + this.data + "    ");
		buf.append(System.lineSeparator());
		if (this.left != null) {
			buf.append(this.left.data);
		} else {
			buf.append("null");
		}
		buf.append("    ");
		if (this.right != null) {
			buf.append("  " + this.right.data);
		} else {
			buf.append("  null");
		}
		return buf.toString();
	}*/
	
	
}
