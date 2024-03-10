import java.util.*;
class Max_size_for_subarray_with_sum_less_than_k {
    public static int blackBox(int a[],int s,int mid){
        int total = 0;
        int n = a.length;
        int sum = 0;
        for(int i=0;i<mid;i++) {
            sum = sum + a[i];
        }
        if(sum <= s) total++;
        int back = 0;
        for(int i=mid;i<n;i++){
            sum = (sum - a[back]) + a[i];
            if(sum<=s)total++;
            back++;
        }
        return total;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        a[i] = in.nextInt();
        int s = in.nextInt();
        int low = 1;
        int high = n;
        int max = 0;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int res = blackBox(a,s,mid);
            if(res != 0){
                if(res > max){
                    max = res;
                    ans = mid;
                    low = mid + 1;
                }
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
