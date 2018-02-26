public class MyDoublyLinkedList<E> {
	Node head; // The head of my list
	Node tail; // The tail of my list

	public MyDoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.previous = head;
	}

	class Node {
		E data;
		Node next;
		Node previous;

		public Node() {
			data = null;
			next = null;
			previous = null;
		}

		public Node(E item, int index) {
			Node current = head;
			int counter = 1;
			while (counter - 1 != index) {
				current = current.next;
				counter++; // To prevent infinite loops, yo
			}
			data = item;
			this.next = current.next;
			current.next = this;
			this.previous = current.previous;
			current.previous = this;
		}
	}

	public int size() {
		if (head.next == tail) {
			return 0;
		}
		Node current = head.next;
		int counter = 0;
		while (current.next != null) {
			current = current.next;
			counter++;
		}
		return counter;
	}

	public void addFirst(E item) {
		Node tempNode = new Node();
		tempNode.data = item;
		// If list is empty check
		if (head.next.data == null) {
			head.next = tempNode;
			tail.previous = tempNode;
			tempNode.previous = head;
			tempNode.next = tail;
			return;
		}
		// At least 1 element inside the list
		tempNode.previous = head;
		tempNode.next = head.next;
		head.next.previous = tempNode;
		head.next = tempNode;
		return;
		// System.out.println("You added: " + item + " to the front of the list");
	}

	public void addLast(E item) {
		Node last_Node = new Node();
		last_Node.data = item;
		// If list is empty check
		if (tail.previous.data == null) {
			tail.previous = last_Node;
			head.next = last_Node;
			last_Node.previous = head;
			last_Node.next = tail;
			return;
		}
		// At least 1 element inside the list
		last_Node.previous = tail.previous;
		last_Node.next = tail;
		tail.previous.next = last_Node;
		tail.previous = last_Node;
		return;
		// System.out.println("You just added: " + item + " to the end of the list");
	}

	public void add(E item, int index) {
		// Checks to avoid null pointer exceptions
		if (index < 0 || index > size()) {
			System.out.println("That's not a valid index, sorry");
			System.out.println("");
			return;
			// Checks using our previous add methods for when the add
			// method is basically acting as the addFirst and addLast methods
		}

		Node new_node = new Node();
		new_node.data = item;
		new_node.next = null;

		if (index == 0) {
			addFirst(item);
		} else if (index == size()) {
			addLast(item);
		} else {

			// If the index passes through these 3 tests, then it
			// finally can proceed to the code below for add

			Node current = head;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}
			System.out.println("Current positon is " + current.data);
			System.out.println();

			new_node.previous = current;
			new_node.next = current.next;
			current.next.previous = new_node;
			current.next = new_node;
		}
	}

	public void removeFirst() {
		if (head.next == tail) {
			System.out.println("There is nothing to remove. The list is empty");
			System.out.println("");
			return;
		} else {
			head = head.next;
			head.previous = null;
		}
	}

	public void removeLast() {
		if (tail.previous == head) {
			System.out.println("There is nothing to remove. The list is empty");
			System.out.println("");
			return;
		} else {
			tail = tail.previous;
			tail.next = null;
		}
	}

	public void remove(int index) {
		if (index < 0 || index > size()) {
			System.out.println("Not A Valid Operation");
			return;
		}
		if (index == 0) {
			removeFirst();
		} else if (index == size()) {
			removeLast();
		} else {
			Node new_node = head;
			for (int i = 0; i < index; i++) {
				new_node = new_node.next;
			}
			new_node.previous.next = new_node.next;
			new_node.next.previous = new_node.previous;
			new_node.next = null;
			new_node.previous = null;
		}
	}

	public void change(E item, int index) {
		// Not sure if a check for when there is only the sentinel head
		// and sentinel tail is needed, but better safe than sorry.
		// We don't like errors in our code
		if (head == null && head.next == null || tail == null && tail.next == null) {
			System.out.println("Error, please check your input");
			return;
		} else {
			// This check against bad index inputs
			if (index < 0 || index >= size()) {
				System.out.println("There nothing to change here");
				System.out.println("");
				return;
			} else {
			}
			Node current = head.next;
			int counter = 0;
			while (counter != index) {
				current = current.next;
				counter++;
			}
			current.data = item;
		}
	}

	public void traverseForward() {
		if (head.next == tail && tail.previous == head) {
			System.out.println("You haven't added anything to your list yet :(");
			System.out.println("");
			return;
		}
		Node current = head.next;
		while (current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println("");
		return;
	}

	public void traverseBackward() {
		if (tail.previous == head && head.next == tail) {
			System.out.println("Your list is empty sir");
			System.out.println("");
			return;
		}
		Node current = tail.previous;
		while (current.previous != null) {
			System.out.println(current.data);
			current = current.previous;
		}
		System.out.println("");
		return;
	}

	public static void main(String[] args) {
		MyDoublyLinkedList<String> list = new MyDoublyLinkedList<String>();
		System.out.println("Your list is: " + list.size());
		System.out.println("");
		list.addFirst("Nick");
		list.addFirst("Nelly");
		list.addFirst("Gerry");
		list.traverseForward();
		list.add("Oscar", 1);
		list.traverseForward();
		list.traverseBackward();
		list.removeFirst();
		list.traverseForward();
		list.traverseBackward();
		list.removeLast();
		list.removeLast();
		list.traverseForward();
		list.traverseBackward();
		System.out.println("Your list is: " + list.size());
		System.out.println("");
	}
}
