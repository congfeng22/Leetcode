using namespace std;
#include <iostream>
#include <unordered_set>

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<int> substr;
        substr.insert(s[0]);
        int l = 0;
        int r = 0;
        int n = s.length();
        int ret = 1;
        if (n == 0){
            return 0;
        }
        while (r < n-1){
            r++;
            while (substr.find(s[r]) != substr.end()){
                substr.erase(s[l]);
                l++;
            }
            substr.insert(s[r]);
            ret = max(r-l+1, ret);
        }
        return ret;
    }
};