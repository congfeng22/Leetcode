class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if height == []:
            return 0
        maxidx = height.index(max(height))
        volume = 0
        curheight = height[0]
        for idx in range(1,maxidx):
            if height[idx]>=curheight:
                curheight = height[idx]
                continue
            volume += curheight - height[idx]
        curheight = height[-1]
        for idx in range(1,len(height)-maxidx):
            if height[-idx]>=curheight:
                curheight = height[-idx]
                continue
            volume += curheight - height[-idx]
            
        return volume
test = Solution()
print(test.trap([5,4,1,2]))