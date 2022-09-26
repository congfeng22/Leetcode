import numpy as np
class RandomizedSet:

    def __init__(self):
        self.list = []
        self.map = {}

    def insert(self, val: int) -> bool:
        if val in self.map:
            return False
        self.list.append(val)
        self.map[val] = len(self.list)-1
        return True
    def remove(self, val: int) -> bool:
        if val in self.map:
            idx = self.map[val]
            if idx != len(self.list)-1:
                self.list[idx] = self.list[-1]
                temp = self.list[-1]
                self.map[temp] = idx
            self.list.pop()
            del self.map[val]
            return True
        else:
            return False

    def getRandom(self) -> int:
        randn = np.random.randint(0,len(self.list))
        return self.list[randn]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()