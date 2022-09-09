using namespace std;
#include <iostream>

class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int minlength = min(ransomNote.length(), magazine.length());
        int map[26] = {};
        for (int i = 0; i < magazine.length(); i++){
            map[magazine[i]-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++){
            map[ransomNote[i]-'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (map[i] < 0){
                return false;
            }
        }
        return true;
    }
};