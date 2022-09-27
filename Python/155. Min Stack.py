class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float('infinity')

    def push(self, val: int) -> None:
        #print("push",self.stack, self.min)
        if not self.stack:
            self.stack.append(val)
            self.min = val
            return
        if val < self.min:
            self.stack.append(val-self.min+val)
            self.min = val
        else:
            self.stack.append(val)
        return

    def pop(self) -> None:
        #print("pop",self.stack, self.min)
        topval = self.stack.pop()
        if topval < self.min:
            self.min = self.min-topval+self.min
        return

    def top(self) -> int:
        #print("top",self.stack, self.min)
        if self.stack[-1] < self.min:
            return self.min
        return self.stack[-1]
        

    def getMin(self) -> int:
        #print("min",self.stack, self.min)
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()