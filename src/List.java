
public class List<Type> {

	Node<Type> begin;
	private Node<Type> end;
	private int size;
	
	public List(){
		begin = new Node<Type>(null, null, null);
		end = begin;
		size = 0;
	}
	
	void pushBack(Type info){
		size++;
		if(begin.equals(end)){
			end = new Node<Type>(null, begin, null);
			begin.setInfo(info);
			begin.setNext(end);
			return;
		}
		end.setInfo(info);
		Node<Type> newNode = new Node<Type>(null, end, null);
		end.setNext(newNode);
		end = newNode;
	}
	
	void pushFront(Type info){
		size++;
		if(begin.equals(end)){
			end = new Node<Type>(null, begin, null);
			begin.setInfo(info);
			begin.setNext(end);
			return;
		}
		Node<Type> newNode = new Node<Type>(info, null, begin);
		begin.setPrev(newNode);
		begin = newNode;
	}
	
	void popBack(){
		if(size == 0){
			return;
		}
		size--;
		if(size == 0){
			begin = end;
			end.setPrev(null);
		}else{
			end.setPrev(end.getPrev().getPrev());
			end.getPrev().setNext(end);
		}
	}
	
	void popFront(){
		if(size == 0){
			return;
		}
		size--;
		if(size == 0){
			begin = end;
			end.setPrev(null);
		}else{
			begin = begin.getNext();
			begin.setPrev(null);
		}
	}
	
	void insert(Iterator pos, Type info){
		if(pos == null || pos.currentIterator.equals(end)){
			return;
		}
		Node<Type> newNode = new Node<Type>(info, pos.currentIterator, pos.currentIterator.getNext());
		pos.currentIterator.getNext().setPrev(newNode);
		pos.currentIterator.setNext(newNode);
	}
	
	void erase(Iterator pos){
		if(pos.currentIterator.equals(begin)){
			popFront();
		}else if (pos.currentIterator.equals(end)){
			return;
		}else{
			pos.currentIterator.getPrev().setNext(pos.currentIterator.getNext());
			pos.currentIterator.getNext().setPrev(pos.currentIterator.getPrev());
			size--;
		}
	}
	
	Type getByIndex(int index){
		Node<Type> current = begin;
		for(int i = 0; i < index; i++){
			current = current.getNext();
		}
		return current.getInfo();
	}
	
	int size(){
		return size;
	}
	
	Iterator begin(){
		return new Iterator(begin);
	}
	
	Iterator end(){
		return new Iterator(end);
	}
	
	public class Iterator{
		public Node<Type> currentIterator;
		
		public Iterator(Node<Type> node){
			currentIterator = node;
		}
		
		public boolean equals(Object obj){
			if(this == obj){
				return true;
			}
			if(obj == null || getClass() != obj.getClass()){
				return false;
			}
			Iterator iterator = (Iterator) obj;
			return currentIterator.equals(iterator.currentIterator);
		}
		
		public void setCurrentIterator(Node<Type> node){
			currentIterator = node;
		}
		public void prev(){
			currentIterator = currentIterator.getPrev();
		}
		public void next(){
			currentIterator = currentIterator.getNext();
		}
		public void set(Type info){
			currentIterator.setInfo(info);
		}
		public Type get(){
			return currentIterator.getInfo();
		}
	}
	
	private class Node<nodeType>{
		private nodeType info;
		private Node<nodeType> prev;
		private Node<nodeType> next;
		
		private Node(nodeType info, Node<nodeType> prev, Node<nodeType> next){
			this.info = info;
			this.prev = prev;
			this.next = next;
		}		
		public nodeType getInfo() {
			return info;
		}
		public void setInfo(nodeType info) {
			this.info = info;
		}
		public Node<nodeType> getNext() {
			return next;
		}
		public void setNext(Node<nodeType> next) {
			this.next = next;
		}
		public Node<nodeType> getPrev() {
			return prev;
		}
		public void setPrev(Node<nodeType> prev) {
			this.prev = prev;
		}
	}

	public Object Node(Object object, Object object2, Object object3) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
