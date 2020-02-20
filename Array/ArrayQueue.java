public class ArrayQueue<T> {
    private static final int DEFAULTCAPACITY=100;
    private int capacity;
    private T[] elements;
    private int front;
    private int rear;

    public int capacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] elements() {
        return elements;
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }

    public int front() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int rear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public ArrayQueue(){
        this.setCapacity(DEFAULTCAPACITY);
        this.setElements((T[]) new Object[100]);
        this.setFront(0);
        this.setRear(0);
    }

    public boolean isEmpty(){
        return this.rear==0;
    }

    public boolean isFull(){
        return this.rear==(this.capacity()-1);
    }

    public boolean enQueue(T anElement){
        if(this.isFull()){
            return false;
        }else{
            this.elements()[rear]=anElement;
            this.setRear(this.rear+1);
            return true;
        }
    }

    public T deQueue(){
        if(this.isEmpty()){
            return null;
        }else{
            T removeElement = this.elements()[front];
            this.elements()[front]=null;
            this.setFront(this.front+1);
            return removeElement;
        }
    }
}
