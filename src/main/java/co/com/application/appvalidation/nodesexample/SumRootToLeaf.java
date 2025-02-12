package co.com.application.appvalidation.nodesexample;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum = currentSum * 10 + node.val;

        // Si es una hoja, devolver el número formado
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        // Recorrer recursivamente los subárboles izquierdo y derecho
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        SumRootToLeaf solution = new SumRootToLeaf();
        System.out.println("Sum of all root-to-leaf numbers: " + solution.sumNumbers(root));
    }
}
