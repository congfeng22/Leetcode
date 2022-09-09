using namespace std;
#include <string>
class Solution {
public:
    int longestPalindrome(string s) {
        int map[52] = {};
        for (int i = 0; i < s.length(); i++){
            if (s[i] >= 'A' && s[i] <= 'Z'){
                map[s[i]-'A'+26]++;
            } else {
                map[s[i]-'a']++;
            }
        }
        bool hasodd = false;
        int ret = 0;
        for (int i = 0; i < 52; i++){
            ret += map[i]/2 * 2;
            if (map[i] % 2 != 0){
                hasodd = true;
            }
        }
        if (hasodd){
            ret++;
        }
        return ret;
    }
};