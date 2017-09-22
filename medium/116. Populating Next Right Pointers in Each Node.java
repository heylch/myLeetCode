public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode start = root.left;
        TreeLinkNode track = root.left;
        while(start != null){
            if(root !=null){
                track.next = root.right;
                track = track.next;
                if(root.next != null)
                    track.next = root.next.left;
            }
            root = root.next;
            track = track.next;
            if(root == null){
                root = start;
                track = start.left;
                start = start.left;
            }
        }
    }