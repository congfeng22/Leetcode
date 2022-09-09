using namespace std;
#include <iostream>
#include <string>
#include <vector>

class Solution {
public:
    string addBinary(string a, string b) {
        vector<char> ret;
        bool carry = false;
        for (int i = 0; i < min(a.length(),b.length()); i++){
            if (a[a.length()-i-1] == '1' && b[b.length()-i-1] == '1'){
                if (carry){
                    ret.push_back('1');
                } else {
                    ret.push_back('0');
                    carry = true;
                }
            } else if (a[a.length()-i-1] == '0' && b[b.length()-i-1] == '0'){
                if (carry){
                    ret.push_back('1');
                    carry = false;
                } else {
                    ret.push_back('0');
                }
            } else {
                if (carry){
                    ret.push_back('0');
                } else {
                    ret.push_back('1');
                }
            }
        }
        if (a.length() > b.length()){
            for (int i = b.length(); i < a.length(); i++){
                if (!carry){
                    ret.push_back(a[a.length()-i-1]);
                } else {
                    if (a[a.length()-i-1] == '1'){
                        ret.push_back('0');                        
                    } else {
                        ret.push_back('1');   
                        carry = false;
                    }
                }
            }
        } else if (a.length() < b.length()){
            for (int i = a.length(); i < b.length(); i++){
                if (!carry){
                    ret.push_back(b[b.length()-i-1]);
                } else {
                    if (b[b.length()-i-1] == '1'){
                        ret.push_back('0');                        
                    } else {
                        ret.push_back('1');   
                        carry = false;
                    }
                }
            }
        } 
        if (carry){
            ret.push_back('1');
        }
        
        string s = "";
        for (int i = 0; i < ret.size(); i++){
            s = s + ret[ret.size()-1-i];
        }
        return s;
    }
};