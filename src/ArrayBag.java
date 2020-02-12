import java.lang.reflect.Array;

public class ArrayBag<T> {
    private int size;
    private int capacity;
    private T[] elements;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

    public ArrayBag(){      //생성자
        this.setSize(0);
        this.setCapacity(100);
        this.setElements((T[]) new Object[100]);        //generic 배열 T[]라는 걸로 형변환하여 객체 생성 객체의 최상위 object로 생성 100개 만큼
    }

    public boolean isEmpty(){
        return this.size()==0;
    }
    public boolean isFull(){
        return this.capacity() == this.size();
    }
    public boolean doesContain(T anElement){
        if(this.isEmpty()){
            return false;
        }else {
            for(int i=0; i<this.size(); i++){
                if(this.elements()[i].equals(anElement)){
                    return true;
                }
            }
        }
        return false;
    }
    public int frequencyOf(T anElement){
        int count=0;
        if(this.isEmpty()){
            return 0;
        }else {

            for(int i=0; i<this.size(); i++){
                if(this.elements()[i].equals(anElement)){
                    count ++;
                }
            }
        }
        return count;
    }
    public T any(){
        if(this.isEmpty()){
            return null;
        }else {
            return this.elements()[0];
        }
    }

    public boolean add(T anElement){
        if(this.isFull()){
            return false;
        }else {
            this.elements()[this.size()]=anElement;
            this.setSize(this.size()+1);
            return true;
        }
    }
    public T removeAny(){
        if(this.isEmpty()){
            return null;
        }else {
            T removeElement = this.elements()[this.size()]; //마지막 원소값을 저장
            this.elements()[this.size()]=null;
            this.setSize(this.size()-1);
            return removeElement;
        }
    }
    public boolean remove(T anElement){
        if(this.isEmpty()){
            return false;
        }else{
            boolean found = false;
            int position = 0;
            for(int i=0; i<this.size(); i++){
                if(this.elements()[i].equals(anElement)){
                    found = true;
                    position = i;
                }
            }
            if(!found){
                return false;
            }else {
                this.elements()[position] = null;
                this.setSize(this.size()-1);
                for(int j=position; j<this.size(); j++){
                    this.elements()[j]=this.elements()[j+1];
                }
                this.elements()[this.size()]= null;
            return true;
            }
        }
    }
    public void clear(){
        for(int i=0; i<this.size(); i++){
            this.elements()[i]=null;
        }
        this.setSize(0);
    }
    public boolean remove2(T anElement){
        if(this.isEmpty()){
            return false;
        }
        else{
            int count =0;
            for(int i=0; i<this.size(); i++){
                if(this.elements()[i].equals(anElement)){
                    this.elements()[i]= null;
                    count++;
                }
            }
            this.setSize(this.size()-count);
            return true;
        }

    }

    public ArrayIterator iterator(){
        return new ArrayIterator();     //객체 생성
    }

    public void printArray(){
        ArrayIterator a = iterator();
        while(a.hasNext()){
            System.out.println(a.next());
        }
    }

    private class ArrayIterator<T> implements Iterator<T>{
        private int nextPosition;

        public int nextPosition() {
            return nextPosition;
        }

        public void setNextPosition(int nextPosition) {
            this.nextPosition = nextPosition;
        }

        private ArrayIterator(){ this.setNextPosition(0);}      //처음부터 탐색해줄거니까 0으로 초기화

        @Override
        public T next() {
            if(!this.hasNext()){
                return null;
            }else {
                T nextElement = (T) (ArrayBag.this.elements()[this.nextPosition()]);
                this.setNextPosition(this.nextPosition() + 1);
                return nextElement;
            }
        }

        public boolean hasNext(){
            return this.nextPosition()<(ArrayBag.this.size());
        }

    }
}
