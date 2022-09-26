def kthSmallest(root,k):
    sizes = {}
    def getsizes(root):
        #print(root.val)
        if root == None:
            return 0
        leftsize = getsizes(root.left)
        rightsize = getsizes(root.right)
        #print(leftsize, rightsize)
        sizes[root.val] = 1 + leftsize + rightsize
        return sizes[root.val]
    getsizes(root)
    
    if root.left == None:
        leftsize = 0
    else:
        leftsize = sizes[root.left.val]
    if k == leftsize + 1:
        return root.val
    elif k > leftsize + 1:
        return kthSmallest(root.right, k-leftsize-1)
    else:
        return kthSmallest(root.left, k)