import java.util.*;

public class Solution {
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> g = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        build(root, g, set);

        int[] res = { 0 };
        Iterator<TreeNode> iterator = set.iterator();
        while (iterator.hasNext()) {
            TreeNode r = iterator.next();
            iterator.remove();
            dfs(r, g, set, res, 0, distance, null);
        }

        return res[0];
    }

    void build(TreeNode root, Map<TreeNode, List<TreeNode>> g, Set<TreeNode> set) {
        if (root.left == null && root.right == null) {
            set.add(root);
        }
        if (!g.containsKey(root)) {
            g.put(root, new ArrayList<>());
        }
        if (root.left != null && !g.containsKey(root.left)) {
            List<TreeNode> neiL = new ArrayList<>();
            neiL.add(root);
            g.put(root.left, neiL);
            List<TreeNode> neiR = g.get(root);
            neiR.add(root.left);
            build(root.left, g, set);
        }
        if (root.right != null && !g.containsKey(root.right)) {
            List<TreeNode> neiR = new ArrayList<>();
            neiR.add(root);
            g.put(root.right, neiR);
            List<TreeNode> neiRoot = g.get(root);
            neiRoot.add(root.right);
            build(root.right, g, set);
        }
    }

    void dfs(TreeNode root, Map<TreeNode, List<TreeNode>> g, Set<TreeNode> set, int[] res, int depth, int limit,
             TreeNode prev) {
        if (root == null || depth > limit) {
            return;
        }

        if (set.contains(root)) {
            res[0]++;
        }

        List<TreeNode> nei = g.get(root);
        for (TreeNode n : nei) {
            if (n != prev) {
                dfs(n, g, set, res, depth + 1, limit, root);
            }
        }
    }
}