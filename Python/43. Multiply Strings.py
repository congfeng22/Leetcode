class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        totalsum = [0]*(len(num1)+len(num2))
        for i in range(len(num1)):
            for j in range(len(num2)):
                pairmul = int(num2[~j])*int(num1[~i])+totalsum[~(i+j)]
                totalsum[~(i+j)-1] += pairmul//10
                totalsum[~(i+j)] = pairmul%10
        return str(int("".join(map(str,totalsum))))
test = Solution()
print(test.multiply('123','456'))