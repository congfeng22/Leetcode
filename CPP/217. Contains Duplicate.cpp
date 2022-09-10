using namespace std;
#include <vector>
#include <unordered_set>

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> appeared;
        for (auto n : nums){
            if (appeared.find(n) != appeared.end()){
                return true;
            }
            appeared.insert(n);
        }
        return false;
    }
};