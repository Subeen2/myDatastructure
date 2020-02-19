public class Recursion {

    public int recursion(int a[], int left, int right){
        if(left==right){
        return a[left];
        }else{
            int max = recursion(a, left+1, right);
            if(a[left]>=max){
                return a[left];
            }else{
                return max;
            }
        }
    }

    public int findMax2(int a[], int left, int right){
        if(left==right){
            return a[left];
        }else{
            int mid = (left+right)/2;
            int leftMax = findMax2(a,left,mid);
            int rightMax = findMax2(a,mid+1,right);
            if(leftMax>=rightMax){
                return leftMax;
            }else{
                return rightMax;
            }
        }
    }
}
