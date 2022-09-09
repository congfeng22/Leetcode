using namespace std;
#include <iostream>
#include <vector>

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int ret = nums[0];
        int count = 1;
        for (int i = 1; i < nums.size()-1; i++){
            if (nums[i] == ret){
                count++;
            } else {
                count--;
            }
            if (count == 0){
                count = 1;
                ret = nums[i+1];
                i++;
            }
        }
        return ret;
    }
};