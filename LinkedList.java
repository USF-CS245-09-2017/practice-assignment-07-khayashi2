
public class LinkedList<T> implements List<T>{

	private int size;
	private Node<T> head;
	public LinkedList() {
		size = 0;
		head = null;
	}

	public void add(T item) {
		if(head == null) {
			Node<T> node = new Node<T>(item);
			head = node;
			++size;
		}
		
		else {
			Node<T>  prev = head;
			for(int i = 0; i < size - 1; i++) {
				prev = prev.next();
			}
			Node<T>  node = new Node<T>(item);
			prev.setNext(node);
			++size;
		}
		
	}

	@Override
	public void add(int pos, T item) {
		Assert.notFalse(pos > 0 && pos < size);
		if(pos == 0) {
			Node<T>  node = new Node<T>(item);
			node.setNext(head);
			head = node;
			
		}
		else {
			Node<T>  prev = head;
			for(int i = 0; i < pos - 1; i++) {
				prev = prev.next();
			}
			Node<T>  node = new Node<T>(item);
			node.setNext(prev.next());
			prev.setNext(node);
		}
		++size;
	}

	@Override
	public T get(int pos) {
		Assert.notFalse(pos > 0 && pos < size);
		Node<T>  curr = head;
		for(int i = 0; i < pos; i++) {
			curr = curr.next();
		}
		return curr.element();
		
	}

	@Override
	public T remove(int pos) {
		Assert.notFalse(pos < size && pos > 0);
		Node<T> curr = null;
		if (pos == 0) {
			curr = head;
			head = curr.next();
			--size;
			return curr.element();
		}
		else {
			Node<T>  prev = head;
			for(int i = 0; i < pos - 1; i++) {
				prev = prev.next();
			}
			curr = prev.next();
			prev.setNext(curr.next());
			return curr.element();
		}
	}

	@Override
	public int size() {
		return size;
	}

}
