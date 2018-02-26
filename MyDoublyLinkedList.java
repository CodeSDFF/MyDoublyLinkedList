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
			int counter = 0;
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
		if (head.next == null || tail.previous == null) {
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
		Node newNode = new Node();
		newNode.data = item;
		// If list is empty check
		if (head.next.data == null) {
			head.next = newNode;
			tail.previous = newNode;
			newNode.previous = head;
			newNode.next = tail;
			return;
		}
		// At least 1 element inside the list
		newNode.previous = head;
		newNode.next = head.next;
		head.next.previous = newNode;
		head.next = newNode;
		// System.out.println("You added: " + item + " to the front of the list");
	}

	public void addLast(E item) {
		Node lastNode = new Node();
		lastNode.data = item;
		// If list is empty check
		if (tail.previous.data == null) {
			tail.previous = lastNode;
			head.next = lastNode;
			lastNode.previous = head;
			lastNode.next = tail;
			return;
		}
		// At least 1 element inside the list
		lastNode.previous = tail.previous;
		lastNode.next = tail;
		tail.previous.next = lastNode;
		tail.previous = lastNode;
		// System.out.println("You just added: " + item + " to the end of the list");
	}

	 public void add(E item, int index) {
	 // Checks to avoid null pointer exceptions
	 if (index < 0 || index > size()) {
	 System.out.println("That's not a valid index, sorry");
	 return;
	
	 // Checks using our previous add methods for when the add
	 // method is basically acting as the addFirst and addLast methods
	
	 } else if (index == 0) {
	 addFirst(item);
	 } else if (index == size()) {
	 addLast(item);
	 } else {
	
	 // If the index passes through these 3 tests, then it
	 // finally can proceed to the code below for add
	
	 Node current = head.next;
	 int counter = 0;
	 while (counter != index - 1) {
	 current = current.next;
	 counter++;
	 }
	
	 Node new_node = new Node();
	 new_node.data = item;
	 new_node.previous= current.previous;
	 new_node.next = current.next;
	 current.next.previous = new_node;
	 current.next = new_node;
	 }
	 }

	// public void removeFirst() {
	// if (head == null || head.next == null) {
	// return;
	// } else {
	// Node temp = head;
	// head = head.next;
	// temp.next = null;
	//
	// /*A small two lines of code if you want to see when this method is used
	// System.out.println();
	// System.out.println("You just removed the original first node");*/
	// }
	// }

	// public void removeFirst() {
	// if (head == null || head.next == null) {
	// return;
	// } else {
	// Node temp = head;
	// head = head.next;
	// temp.next = null;
	//
	// /*A small two lines of code if you want to see when this method is used
	// System.out.println();
	// System.out.println("You just removed the original first node");*/
	// }
	// }

	// public void removeLast() {
	// if (head == null || head.next == null) {
	// return;
	// } else {
	// Node current = head;
	// while (current.next.next != null) {
	// current = current.next;
	// }
	// current.next = null;
	// // You can use these two greyed out lines
	// // to double that you actually removed the last node
	// // System.out.println();
	// // System.out.println("You just removed the last node");
	// }
	// }

	// public void remove(int index) {
	// Node current = head;
	// int counter = 0;
	// while(counter-1 != index) {
	// counter++;
	// current = current.next;
	// }
	//
	// System.out.println("This is: " + current.data);
	//
	// current.previous.next = current.next;
	// current.next.previous = current.previous;
	// current.next = null;
	// current.previous = null;
	// }
	
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
			System.out.println("You got nothing here boss");
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
		list.addLast("Nick");
		list.addLast("Nelly");
		list.addFirst("Gerry");
		list.traverseForward();
		list.traverseBackward();
		System.out.println("Your list size is: " + list.size());
		System.out.println("");
		list.add("Oscar", 2);
		System.out.println("");
		list.traverseForward();
		list.traverseBackward();
		System.out.println("Your list size is: " + list.size());
		System.out.println("");
		list.change("Oscar Jr", 1);
		list.traverseForward();
		list.traverseBackward();
	}
}
