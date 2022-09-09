using namespace std;
#include <iostream>
#include <vector>

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        vector<int> stack;
        int row_size = image[0].size();
        stack.push_back(sr*row_size+sc);
        int orig_color = image[sr][sc];
        if (orig_color == color){
            return image;
        }
        while (stack.size() != 0){
            int curr = stack.back();
            stack.pop_back();
            if (curr >= image.size()*row_size){
                continue;
            }
            if (image[curr/row_size][curr%row_size] == orig_color){
                image[curr/row_size][curr%row_size] = color;
                if (curr%row_size != 0){
                    stack.push_back(curr-1);
                }
                if (curr%row_size != row_size-1){
                    stack.push_back(curr+1);
                }
                if (curr/row_size != 0){
                    stack.push_back(curr-row_size);
                }
                if (curr/row_size != image.size()-1){
                    stack.push_back(curr+row_size);
                }
            }
        }
        return image;
    }
};