// recursion
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        root.left.next = root.right;
        root.right.next = root.next == null ? null: root.next.left;
        connect(root.left);
        connect(root.right);
    }
}

//Two Pointers Constant Space
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        TreeLinkNode start = root.left;
        TreeLinkNode track = root.left;
        while(start != null){
            track.next = root.right;
            track = track.next;
            root = root.next;
            if(root != null){
                track.next = root.left;
                track = track.next;
            }
            else{
                root = start;
                start = start.left;
                track = start;
            }
        }
    }
}