class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        maxvol = 0
        maxheight = max(height)
        maxpos = height.index(maxheight)
        rheight = height[::-1]
        leftpeaks = [0]
        rightpeaks = [len(height)-1]
        cur_highest = height[0]
        for i in range(1,len(height)):
            if i > maxpos:
                break
            if height[i]>=cur_highest:
                leftpeaks.append(i)
                cur_highest = height[i]
        cur_highest = rheight[0]
        for i in range(1,len(height)):
            if i > len(height)-maxpos-1:
                break
            if rheight[i]>=cur_highest:
                rightpeaks.append(len(height)-i-1)
                cur_highest = rheight[i]
        rightpeaks = rightpeaks[::-1]
        
        for pos1 in leftpeaks:
            for pos2 in rightpeaks:
                maxvol = max(maxvol,(pos2-pos1)*min(height[pos1],height[pos2]))
        
        return maxvol
test = Solution()
print(test.maxArea([1,8,6,2,5,4,8,3,7]))