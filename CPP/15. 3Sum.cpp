using namespace std;
#include <iostream>
#include <vector>
#include <algorithm>

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ret;
        int l;
        int r;
        for (int i = 0; i < nums.size(); i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            l = i + 1;
            r = nums.size() - 1;
            while (l < r){
                if (nums[i] + nums[l] + nums[r] > 0){
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0){
                    l++;
                } else {
                    vector<int> trip;
                    trip.push_back(nums[i]);
                    trip.push_back(nums[l]);
                    trip.push_back(nums[r]);
                    ret.push_back(trip);
                    while (l < r && nums[l+1] == nums[l]){
                        l++;
                    }
                    l++;
                    while (l < r && nums[r-1] == nums[r]){
                        r--;
                    }
                    r--;
                }
            }
        }
        return ret;
    }
};