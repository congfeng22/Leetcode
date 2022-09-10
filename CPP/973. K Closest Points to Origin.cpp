using namespace std;
#include <vector>
#include <algorithm>
#include <math.h>

class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        sort(points.begin(), points.end(), [](const vector<int>& a, const std::vector<int>& b) {
            return pow(a[0],2)+pow(a[1],2) < pow(b[0],2)+pow(b[1],2);
        });
        return vector<vector<int>>(points.begin(), points.begin()+k);
    }
};