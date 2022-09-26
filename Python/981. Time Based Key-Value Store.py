class TimeMap:

    def __init__(self):
        self.map = {}
        # m[key] = list of (timestamp, value) pairs. sorted by inc timestamp. do binary search for get. append to tail for set.

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        self.map[key].append((timestamp, value))        

    def get(self, key: str, timestamp: int) -> str:
        #print(self.map.get(key,0))
        if key not in self.map or self.map[key][0][0]>timestamp:
            return ""
        alist = self.map[key]
        # find largest index where condition (timestamp at idx <= input timestamp) is met
        l, r = 0, len(alist)-1
        while l < r:
            mid = l + (r-l+1)//2
            if alist[mid][0] <= timestamp:
                l = mid
            else:
                r = mid - 1
        return alist[l][1]

# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)