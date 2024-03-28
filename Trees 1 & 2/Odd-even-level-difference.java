//@gfg
class Solution
{
	int getLevelDiff(Node root)
	{
	    int oddSum = 0;
	    int evenSum = 0;
	    Queue<Node> q = new LinkedList<>();
	    int lvl = 0;
	    if(root == null) return 0;
	    q.add(root);
	    while(!q.isEmpty()) {
	        int size = q.size();
	        lvl++;
	        for(int i=0;i<size;i++) {
	            Node cur = q.remove();
	            if(lvl % 2 == 0)
	            evenSum += cur.data;
	            else
	            oddSum += cur.data;
	            if(cur.left != null)
	            q.add(cur.left);
	            if(cur.right != null)
	            q.add(cur.right);
	        }
	    }
	    return oddSum - evenSum;
	}
}