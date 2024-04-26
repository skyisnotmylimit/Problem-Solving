//@InterviewBit
public class Solution {
    public int solve(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] == -1) {
                root = i;
            } else {
                tree.get(A[i]).add(i);
                tree.get(i).add(A[i]);
            }
        }
        int[] distances1 = bfs(tree, root);
        int farthestNode1 = root;
        for (int i = 0; i < n; i++) {
            if (distances1[i] > distances1[farthestNode1]) {
                farthestNode1 = i;
            }
        }
        int maxDistance1 = distances1[farthestNode1];
        int[] distances2 = bfs(tree, farthestNode1);
        int maxDistance2 = 0;
        for (int distance : distances2) {
            maxDistance2 = Math.max(maxDistance2, distance);
        }
        return maxDistance2;
    }
    private int[] bfs(ArrayList<ArrayList<Integer>> tree, int start) {
        int n = tree.size();
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distances[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDistance = distances[node];
            for (int neighbor : tree.get(node)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = currentDistance + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return distances;
    }
}
