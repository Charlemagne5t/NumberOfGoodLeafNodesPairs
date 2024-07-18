import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(59);
        root.left = new TreeNode(11);
        root.right = new TreeNode(44);

        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(46);
        root.right.left = new TreeNode(57);
        root.right.right = new TreeNode(88);

        root.left.left.left = new TreeNode(59);
        root.left.left.right = new TreeNode(25);
    }
}
