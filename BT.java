import java.util.*;

public class BT {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int indx = -1;
        public static Node buildTree(int node[]){
            indx++;
            if( node[indx] == -1){
                return null;
            }
            Node newNode = new Node(node[indx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }

        //preorder
        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        //inorder
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        //postorder
        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        //levelorder
        public static void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

    }

    static class Info{
        int diameter;
        int height;

        public Info(int diam, int ht){
            this.diameter = diam;
            this.height = ht;
        }
    }


    //height of tree
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    //total nodes
    public static int numNode(Node root){
        if(root == null){
            return 0;
        }
        int ln = numNode(root.left);
        int rn = numNode(root.right); 
        return ln + rn + 1;
    }

    //total sum nodes
    public static int sumNode(Node root){
        if(root == null){
            return 0;
        }
        return sumNode(root.left) + sumNode(root.right) + root.data;
    }

    //maximum diameter
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int LD = diameter(root.left);
        int RD = diameter(root.right);
        int LH = height(root.left);
        int RH = height(root.right);
        int selfDia = LH + RH ;
        return Math.max(selfDia, Math.max(RD, LD));
    }

    //maximum diameter approach 2
    public static Info diamete2(Node root){
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diamete2(root.left);
        Info rightInfo = diamete2(root.right);
        int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height +1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(diam, height);
    }

    //subtree
    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static boolean isIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null){
            return true;
        }else if(root == null || subRoot == null || root.data != subRoot.data){
            return false;
        }
        if(!isIdentical(root.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(root.right, subRoot.right)){
            return false;
        }
        return true;
    }

    //Kth level of tree
    public static void Klevel(Node root, int level, int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data +" ");
            return;
        }
        Klevel(root.left, level+1, k);
        Klevel(root.right, level+1, k);
    }

    //lowest common ancestor
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        return path1.get(i - 1);
    }
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if( root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        boolean foudLeft = getPath(root.left, n, path);
        boolean foudRight = getPath(root.right, n, path);
        if(foudLeft || foudRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    //lowest common ancestor approach - 2
    public static Node lca2(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //Case 1
        if(rightLca == null){
            return leftLca;
        }
        //case 2
        if(leftLca == null){
            return rightLca;
        }
        return root;
    }

    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
            return rightDist + 1;
        }else{
            return leftDist + 1;
        }
    }
    //minimum distance
    public static int minDistance(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2; 
    }

    public static void main(String[] args) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root); 

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(9);

        // System.out.println("height : " + height(root));
        // System.out.println("number of Nodes : " +numNode(root));
        // System.out.println("sum of Nodes : " + sumNode(root));
        // System.out.println("maximum diameter : " + diameter(root));
        // System.out.println("maximum diameter approach 2 : " + diamete2(root).diameter);
        // System.out.println(isSubtree(root, subRoot));
        // Klevel(root, 1, 2);
        // System.out.println(lca(root, 1, 2).data);
        System.out.println(minDistance(root, 4, 6));
    }
}
