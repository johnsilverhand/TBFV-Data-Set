import java.util.List;
import java.util.Arrays;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class IsValidBST {
    
    public static boolean isValidBST(TreeNode root, List<Integer> vec) {
        // 空树的情况
        if (root == null) {
            return true;
        }

        // 检查 vec 是否严格递增
        for (int i = 1; i < vec.size(); i++) {
            if (vec.get(i) < vec.get(i - 1)) { // 错误：应该是 <=
                return false;
            }
        }
        return true;
    }

    

    public static void main(String[] args) {
        // 示例二叉树
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // 模拟生成 vec
        List<Integer> vec = Arrays.asList(1, 2, 3);

        // 验证 BST
        boolean result = isValidBST(root, vec);
        System.out.println("Is valid BST: " + result);
    }
}
