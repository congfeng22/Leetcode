import random
class Solution:

    def __init__(self, w):
        self.cumweights = w
        for i in range(1,len(w)):
            self.cumweights[i] += self.cumweights[i-1]

    def pickIndex(self):
        search = random.randint(1, self.cumweights[-1])
        # find smallest index of number that is >= search
        l,r = 0,len(self.cumweights)-1
        while l<r:
            mid = l + (r-l)//2
            if self.cumweights[mid] >= search:
                r = mid
            else:
                l = mid + 1
        return l
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()