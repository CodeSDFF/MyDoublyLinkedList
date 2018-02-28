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
				counter++; // To prevent infinite loops
			}
			data = item;
			this.next = current.next;
			current.next = this;
			this.previous = current.previous;
			current.previous = this;
		}
	}

	public int size() {
		if (head.next.data == null) {
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
		// Checks to see if list is empty
		if (head.next.data == null) {
			head.next = tempNode;
			tail.previous = tempNode;
			tempNode.previous = head;
			tempNode.next = tail;
			return;
		}
		// At least 1 item inside the list
		tempNode.previous = head;
		tempNode.next = head.next;
		head.next.previous = tempNode;
		head.next = tempNode;
		return;
		// A line of code below if you want to see what you added, for checks
		// System.out.println("You added: " + item + " to the front of the list");
	}

	public void addLast(E item) {
		Node last_Node = new Node();
		last_Node.data = item;
		// Checks to see if list is empty
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
		// A line of code below if you want to see what you added, for checks
		// System.out.println("You just added: " + item + " to the end of the list");
	}

	public void add(E item, int index) {
		// Checks to avoid null pointer exceptions
		if (index < 0 || index > size()) {
			System.out.println("That's not a valid index, sorry");
			System.out.println("");
			return;
		}

		Node new_node = new Node();
		new_node.data = item;
		new_node.next = null;

		// Checks using our previous add methods for when the add()
		// method is basically acting as the addFirst and addLast methods

		if (index == 0) {
			addFirst(item);
		} else if (index == size()) {
			addLast(item);
		} else {

		// If the index passes through these 3 tests, then it
		// can finally proceed to the code below for add

			Node current = head.next;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			
			// Use this line of code below to make sure what you
		    // think is happening with the code is actually happening
			// very good for figuring out how to write the new pointers
			
			System.out.println("Current positon is " + current.data);
			System.out.println();

			new_node.previous = current.previous;
			new_node.next = current;
			current.previous.next = new_node;
			current.previous = new_node;
		}
	}

	public void removeFirst() {
		// Check to see if the list is empty
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
		// Check to see if the list is empty
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
		// Just a small print out to help you see
		// what is being removed when the code runs
		// and how large the list size is before the removal
		
		System.out.println("An Item is about to be removed");
		System.out.println("List Size is: " + size());
		System.out.println("");
		
		// Again we need to make sure our index isn't out of bounds
		if (index < 0 || index > size() - 1) {
			System.out.println("Index is out of bounds");
			System.out.println("");
			return;
		}
		// Like before we use our previous remove methods to
		// handle the cases we've already covered
		if (index == 0) {
			removeFirst();
		} else if (index == size() - 1) {
			removeLast();
		} else {
			Node new_node = head.next;
			for (int i = 0; i < index; i++) {
				new_node = new_node.next;
			}
		// Just a small way double checking your code is actually
		// doing what you want it to be doing. It can be removed later
		// if so desired without affecting the program.
			System.out.println("Current positon is " + new_node.data);
			System.out.println("The item that should be removed is " + new_node.data);
			System.out.println();

			new_node.previous.next = new_node.next;
			new_node.next.previous = new_node.previous;
			new_node.next = null;
			new_node.previous = null;
		}
	}

	public void change(E item, int index) {
		// Just a check to make sure the list isn't empty.
		// Not sure if it is needed, but better safe than sorry
		if (head.next == null || tail.previous == null) {
			System.out.println("Unforunately, there are no items in your list to change");
			System.out.println("");
			return;
		} else {
		// This checks against bad index inputs
			if (index < 0 || index >= size()) {
				System.out.println("Change cannot happen. Index is out of bounds");
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
			System.out.println("Your list is empty");
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
			System.out.println("Your list is empty");
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
		System.out.println("Your list size is: " + list.size());
		System.out.println("");
		
	
//		list.removeFirst();
//		list.removeLast();
//		list.remove(0);
//		list.remove(2);
//		list.remove(-1);
//		list.change("Test", -1);
//		list.change("Test2", 5);
//		list.traverseForward();
//		list.traverseBackward();
//		System.out.println("No more checks to do for now, let's get to it!");
//		System.out.println("");
//		list.addFirst("Nick");
//		list.addLast("Gerry");
//		list.traverseForward();
//		list.traverseBackward();
//		list.add("Nelly", 3);
//		list.add("Nelly", -1);
//		list.add("Nelly", 1);
//		list.traverseForward();
//		list.traverseBackward();
//		list.addLast("Oscar");
//		list.addLast("Aleks");
//		list.traverseForward();
//		list.traverseBackward();
//		list.change("Oscar Jr", -1);
//		list.change("Oscar Jr", 5);
//		list.change("Oscar Jr", 3);
//		list.traverseForward();
//		list.traverseBackward();
//		list.remove(-1);
//		list.remove(5);
//		list.remove(2);
//		list.traverseForward();
//		list.traverseBackward();
//		list.removeFirst();
//		list.removeLast();
//		list.removeLast();
//		list.traverseForward();
//		list.traverseBackward();
//		System.out.println("Thanks for stopping by, that's my doubly linked list");
	}
}
