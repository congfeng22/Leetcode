using namespace std;
#include <iostream>
#include <algorithm>

class Solution {
public:
    bool isAnagram(string s, string t) {
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        if (t == s){
            return true;
        }
        return false;
        // unordered_map<char,int> m;
        // if (s.length() != t.length()){
        //     return false;
        // }
        // for (int i = 0; i < s.length(); i++){
        //     if (!m.count(s[i])){
        //         m[s[i]] = 0;
        //     }
        //     m[s[i]]++;
        // }
        // for (int i = 0; i < t.length(); i++){
        //     if (!m.count(t[i])){
        //         return false;
        //     }
        //     if (m[t[i]]<=0){
        //         return false;
        //     }
        //     m[t[i]]--;
        // }
        // return true;
    }
};