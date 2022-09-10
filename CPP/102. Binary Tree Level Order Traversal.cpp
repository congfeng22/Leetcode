using namespace std;
#include <vector>
#include <iostream>
#include <queue>

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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ret;
        if (root == nullptr){
            return ret;
        }
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()){
            vector<int> elm;
            int n = q.size();
            for (int i = 0; i < n; i++){
                TreeNode* curr = q.front();
                q.pop();
                elm.push_back(curr->val);
                if (curr->left != nullptr){
                    q.push(curr->left);
                }
                if (curr->right != nullptr){
                    q.push(curr->right);
                }
            }
            ret.push_back(elm);
        }
        return ret;
    }
};