using namespace std;
#include <iostream>
#include <vector>

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
    vector<int> helper(TreeNode* root){
        // returns [longest to left, diam, longest to right]
        vector<int> ret;
        if (root == nullptr){
            ret.push_back(-1);
            ret.push_back(-1);
            ret.push_back(-1);
            return ret;
        } else if (root->left == nullptr && root->right == nullptr){
            ret.push_back(0);
            ret.push_back(0);
            ret.push_back(0);
        }
        vector<int> left = helper(root->left);
        vector<int> right = helper(root->right);
        ret.push_back(max(left.at(0), left.at(2)) + 1);
        ret.push_back(max(max(max(left.at(0), left.at(2)) + 1 + max(right.at(0), right.at(2)) + 1, left.at(1)), right.at(1)));
        ret.push_back(max(right.at(0), right.at(2)) + 1);
        return ret;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        vector<int> ans = helper(root);
        return ans.at(1);
    }
};