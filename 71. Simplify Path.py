class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        pathlist = path.split("/")
        newpath = []
        for i in pathlist:
            if i == "..":
                if len(newpath)>0:
                    del newpath[-1]
            elif i!="" and i!=".":
                newpath.append(i)
        return "/"+"/".join(newpath)
test = Solution()
print(test.simplifyPath("/./"))