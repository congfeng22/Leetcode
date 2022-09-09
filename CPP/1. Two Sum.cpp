using namespace std;
#include <iostream>
#include <vector>
#include <algorithm>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<vector<int>> temp;
        for (int i = 0; i < nums.size(); i++){
            vector<int> a = {nums.at(i),i};
            temp.push_back(a);
        }
        sort(temp.begin(), temp.end());
        int l = 0;
        int r = temp.size()-1;
        while (l<r){
            int curr = temp.at(l).at(0) + temp.at(r).at(0);
            if (curr == target){
                std::vector<int> v = {temp.at(l).at(1),temp.at(r).at(1)};
                return v;
            } else if (curr < target){
                l++;
            } else {
                r--;
            }
        }
        return nums;
    }
};