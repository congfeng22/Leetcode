class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def buildTree(preorder, inorder):
    # preorder = root, left, right
    # inorder = left, root, right
    # using preorder, know what the root is
    # using root val and inorder, know what left and right are
    # recurse
    def helper(preorder, inorder, pl, pr, il, ir):
        #print(pl, pr, il, ir)
        if pr==pl:
            return TreeNode(preorder[pl])
        if pl>pr:
            return None
        rootval = preorder[pl]
        rootidxIn = inorder.index(rootval)
        leftsize, rightsize = rootidxIn-il, ir-rootidxIn
        left = helper(preorder, inorder, pl+1, pl+leftsize, il, il+leftsize-1)
        right = helper(preorder, inorder, pr-rightsize+1, pr, ir-rightsize+1, ir)
        root = TreeNode(rootval)
        root.left = left
        root.right = right
        return root
    return helper(preorder, inorder, 0, len(preorder)-1, 0, len(inorder)-1)