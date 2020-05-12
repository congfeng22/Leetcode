public class PopulatingNextRightPointersinEachNode116 {
    public Node connect(Node root) {
        if (root==null) return root;
        root.left = connect(root.left);
        root.right = connect(root.right);
        Node l = root.left;
        Node r = root.right;
        while (l!=null){
            l.next=r;
            l=l.right;
            r=r.left;
        }
        return root;
    }
}
