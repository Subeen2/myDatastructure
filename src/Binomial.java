public class Binomial {
        public int binomial(int n, int m){
            if(m==0 || n==m){
                return 1;
            }else if(n>m && m>0){
                return binomial(n-1,m)+binomial(n-1,m-1);
            }else return -1;
        }

//    Binomial bino = new Binomial();
//    int n=4;
//    int m=2;
//    int result;
//    result = bino.binomial(n,m);
//        System.out.println(result);
}
