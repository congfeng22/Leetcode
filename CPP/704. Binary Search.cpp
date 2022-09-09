using namespace std;
#include <iostream>
#include <vector>

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0;
        int r = nums.size()-1;
        while (l <= r){
            int m = l + (r-l)/2;
            if (nums[m] == target){
                return m;
            } else if (nums[m] < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
};
int main() {
    vector<int> vect{-1,0,3,5,9,12};
    Solution s = Solution();
    cout << s.search(vect, 9);
    return 0;
}