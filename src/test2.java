public class test2 {
    public static void main(String args[]) {
        LinkedStack<Integer> test1 = new LinkedStack();
//        ArrayStack<Integer> test1 = new ArrayStack();
        System.out.println(test1.isEmpty());
        System.out.println(test1.isFull());
        System.out.println(test1.push(3));
        System.out.println(test1.push(4));
        System.out.println(test1.push(5));
        System.out.println(test1.peek());
        System.out.println(test1.pop());
        System.out.println(test1.peek());
        System.out.println(test1.push(6));
        System.out.println(test1.peek());
        System.out.println(test1.size());
    }
}
