using namespace std;
#include <iostream>
#include <vector>
class Solution {
public:
    bool isValid(string s) {
        vector<char> stack;
        for (int i = 0; i < s.length(); i++){
            if (s[i] == '(' || s[i] == '[' || s[i] == '{'){
                stack.push_back(s[i]);
                // cout << s[i];
            } else if (s[i] == ')' && stack.size()>0 && stack.back() != '('){
                return false;
            } else if (s[i] == ']' && stack.size()>0 && stack.back() != '['){
                return false;
            } else if (s[i] == '}' && stack.size()>0 && stack.back() != '{'){
                return false;
            } else if (stack.size() == 0){
                return false;
            } else {
                // cout << s[i];
                stack.pop_back();
                // cout << stack.size();
            }            
        }
        if (stack.size() > 0){
            return false;
        }
        return true;
    }
};