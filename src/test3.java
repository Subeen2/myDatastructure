public class test3 {
    public static void main(String args[]){
        LinkedQueue<Integer> test = new LinkedQueue();
        System.out.println(test.isEmpty());
        System.out.println(test.isFull());
        System.out.println(test.enQueue(1));
        System.out.println(test.enQueue(2));
        System.out.println(test.enQueue(3));
        System.out.println(test.deQueue());
        System.out.println(test.deQueue());
        System.out.println(test.front());
        System.out.println(test.rear());
        System.out.println(test.enQueue(3));
        System.out.println(test.deQueue());
    }
}
