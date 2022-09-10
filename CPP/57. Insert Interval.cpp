using namespace std;
#include <vector>

class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> ret;
        bool inserted = false;
        for (int i = 0; i < intervals.size(); i++){
            vector<int> curr = intervals.at(i);
            if (inserted){
                ret.push_back(curr);
                continue;
            }
            // no overlapping
            if (curr.at(1) < newInterval.at(0)){
                ret.push_back(curr);
            } else if (curr.at(0) > newInterval.at(1)) {
                ret.push_back(newInterval);
                ret.push_back(curr);
                inserted = true;
            } else {
                newInterval.at(0) = min(newInterval.at(0), curr.at(0));
                newInterval.at(1) = max(newInterval.at(1), curr.at(1));
            }
        }
        if (!inserted){
            ret.push_back(newInterval);
        }
        return ret;
    }
};