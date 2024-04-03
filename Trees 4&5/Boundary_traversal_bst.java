//@GFG


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    
    static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    
    static void leftBoundary(Node node, ArrayList<Integer> arr){
        Node current = node.left;
        while(current!=null){
            if(!isLeaf(current))
                arr.add(current.data);
            if(current.left != null)
                current = current.left;
            else
                current = current.right;
        }
    }
    
    static void rightBoundary(Node node, ArrayList<Integer> arr){
        Node current = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(current != null){
            if(!isLeaf(current))
                temp.add(current.data);
            if(current.right != null)
                current = current.right;
            else
                current = current.left;
        }
        for(int i = temp.size()-1;i>=0;i--){
            arr.add(temp.get(i));
        }
    }
    
    static void leafBoundary(Node node, ArrayList<Integer> arr){
        if(isLeaf(node)){
            arr.add(node.data);
            return;
        }
        if(node.left != null)
            leafBoundary(node.left, arr);
        if(node.right != null)
            leafBoundary(node.right,arr);
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> arr = new ArrayList<>();
	    if(node == null)
	        return arr;
	    if(isLeaf(node)){
	        arr.add(node.data);
	        return arr;
	    }
	    arr.add(node.data);
	    leftBoundary(node,arr);
	    leafBoundary(node,arr);
	    rightBoundary(node,arr);
	    return arr;
	}
}
