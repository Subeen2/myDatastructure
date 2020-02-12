public class LinkedBag<T> {
    private int size;
    private LinkedNode<T> head;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedNode<T> head() {
        return head;
    }

    public void setHead(LinkedNode<T> head) {
        this.head = head;
    }

    public LinkedBag(){
        this.setSize(0);
        this.setHead(null);
    }
    public boolean isEmpty(){
        return this.size()==0;
    }

    public boolean isFull(){
        return false;
    }
    public boolean doesContain(T anElement){
        if(this.isEmpty()){
            return false;
        }
        else {
            LinkedNode<T> current = this.head();
            boolean found = false;
            while (current != null) {
                if (current.element().equals(anElement)) {
                    found = true;
                }
                current = current.next();
            }
            return false;
        }
    }
    public int frequencyOf(T anElement){
        if(this.isEmpty()){
            return 0;
        }else {
            LinkedNode<T> current = this.head();
            int count = 0;
            while(current != null){
                if(current.element().equals(anElement)){
                    count ++;
                }
                current = current.next();
             }
            return count;
        }
    }
    public T any(){
        return this.head().element();
    }
    public boolean add(T anElement){
        LinkedNode<T> addNode = new LinkedNode(anElement);
        this.setSize(this.size()+1);
        addNode.setNext(this.head());
        this.setHead(addNode);
        return true;
    }
    public T removeAny(){
        if(this.isEmpty()){
            return null;
        }else {
            T removeElement = this.head().element();
            this.setHead(this.head().next());
            this.setSize(this.size()-1);
            return removeElement;
    }
    }
    public boolean remove(T anElement){
        if(this.isEmpty()){
            return false;
        }else {
            LinkedNode<T> previous = null;
            LinkedNode<T> current = this.head();
            boolean found = false;
            while(current != null && !found){
                if(current.element().equals(anElement)){
                    found = true;
                }else {
                    previous = current;
                    current = current.next();
                }

            }

            if(!found ){
                return false;
            }else {
                if(current==this.head()){
                    this.setHead(this.head().next());
                }else {
                    current.setNext(current.next());
                }
                this.setSize(this.size()-1);
                return true;
            }
        }
    }
    public void clear(){
        this.setSize(0);
        this.setHead(null);
    }

    public void printNode(){
        ListIterator a = iterator();
        while(a.hasNext()){
            System.out.println(a.next());
        }
    }


    public ListIterator iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private LinkedNode<T> nextNode;

        public LinkedNode<T> nextNode() {
            return nextNode;
        }

        public void setNextNode(LinkedNode<T> nextNode) {
            this.nextNode = nextNode;
        }
        private ListIterator(){
            this.nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return this.nextNode()!=null;
        }

        @Override
        public T next() {
            if(!this.hasNext()){
                return null;
            }else {
                T nextElement = this.nextNode.element();
                this.nextNode = this.nextNode().next();
                return nextElement;
            }
        }




    }
}
