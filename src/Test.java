public class Test {
    public static void main(String args[]){
        ArrayBag<Integer> test1 = new ArrayBag();       //int 성질을 갖는 값이 들어간다.
        System.out.println(test1.isEmpty());
        System.out.println(test1.isFull());
        test1.add(1);
        System.out.println(test1.doesContain(1));
        System.out.println(test1.any());
        test1.add(1);
        System.out.println(test1.frequencyOf(1));
        System.out.println(test1.remove(1));
        System.out.println(test1.any());
        test1.add(2);
        test1.add(3);
        System.out.println(test1.remove(2));
        System.out.println(test1.any());
    }
}
