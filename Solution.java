import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String order = in.next();
        int n = in.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        list.add(in.next());
        int priority[] = new int[26];
        int i = 0;
        for(char ch : order.toCharArray()) {
            priority[ch - 'a'] = i++;
        }
        Comparator cmp = new Comparator(){
            @Override
            public int compare()
        };
    }
}
