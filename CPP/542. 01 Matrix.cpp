using namespace std;
#include <iostream>
#include <vector>
#include <unordered_set>
#include <queue>

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int mult = mat[0].size();
        queue<int> zeroes;
        for (int i = 0; i < mat.size(); i++){
            for (int j = 0; j < mat[0].size(); j++){
                if (mat[i][j] == 0){
                    zeroes.push(i*mult+j);
                }
            }
        }
        unordered_set<int> visited;
        int dist = 0;
        while (!zeroes.empty()){
            int len = zeroes.size();
            for (int i = 0; i < len; i++){
                int curr = zeroes.front();
                zeroes.pop();
                mat[curr/mult][curr%mult] = dist;
                if (curr/mult > 0 && mat[curr/mult-1][curr%mult] == 1 && visited.find(curr-mult)==visited.end()){
                    zeroes.push(curr-mult);
                    visited.insert(curr-mult);
                }
                if (curr/mult < mat.size()-1 && mat[curr/mult+1][curr%mult] == 1 && visited.find(curr+mult)==visited.end()){
                    zeroes.push(curr+mult);
                    visited.insert(curr+mult);
                }
                if (curr%mult > 0 && mat[curr/mult][curr%mult-1] == 1 && visited.find(curr-1)==visited.end()){
                    zeroes.push(curr-1);
                    visited.insert(curr-1);
                }
                if (curr%mult < mult-1 && mat[curr/mult][curr%mult+1] == 1 && visited.find(curr+1)==visited.end()){
                    zeroes.push(curr+1);
                    visited.insert(curr+1);
                }
            }
            dist++;
        }
        return mat;
    }
};