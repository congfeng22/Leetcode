using namespace std;
#include <iostream>

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        return helper(root)[2];
    }
    int * helper(TreeNode* root) {
        if (root == nullptr){
            return new int[]{0,0,1};
        }
        int * left = helper(root->left);
        int * right = helper(root->right);
        int balanced = abs(max(left[0],left[1]) - max(right[0],right[1])) <= 1;
        return new int[]{max(left[0],left[1])+1, max(right[0],right[1])+1,min(min(left[2],right[2]),balanced)};
    }
};
int main() {
    Solution s = Solution();
    s.isBalanced(new TreeNode());
    cout << "hi";
    return 0;
}