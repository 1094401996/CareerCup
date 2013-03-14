__metaclass__ = type
#career 3.5
#Implement a MyQueue class which implements a queue using two stacks.
#两个堆栈来回倒
#有用的链接：http://www.cnblogs.com/wanghui9072229/archive/2011/11/22/2259391.html

class MyStack:
    def __init__(self,capacity = 20):
        self.stack = []
        self.capacity = capacity
        self.top = 0
    def setCapacity(self,capacity):
        self.size = size
    def push(self,element):
        if self.isFull():
            raise 'PyStackOverFlow'
        else:
            self.stack.append(element) 
            self.top = self.top + 1 
    def pop(self):
        if self.isEmpty():
            raise 'PyStackUnderFlow'
        else:
            self.top -= 1
            return self.stack.pop()
    def size(self):
        return self.top
    def flush(self):
        self.stack = []
        self.top = 0
    def isEmpty(self):
        return self.top == 0
    def isFull(self):
        return self.top == self.capacity
class MyQueue:
    def __init__(self,capacity = 20):
        self.size = 0
        self.capacity = capacity
        self.stack1 = MyStack(capacity)
        self.stack2 = MyStack(capacity)
    def setCapacity(self,capacity):
        self.capacity = capacity
        self.stack1.setSize(capacity)
        self.stack2.setSize(capacity)
    def enqueue(self,element):
        if not self.stack1.isFull():
            self.stack1.push(element)
            self.size += 1
        else:
            raise 'PyStackOverFlow'
    def dequeue(self):
        if not self.stack2.isEmpty():
            return self.stack2.pop()
        else:
            if self.stack1.isEmpty():
                raise 'PyStackUnderFlow'
            else:
                while not self.stack1.isEmpty():
                    self.stack2.push(self.stack1.pop())
                    self.size -= 1
                return self.stack2.pop()
if __name__ == '__main__':
    myqueue = MyQueue(20)
    for i in range(5,10):
        myqueue.enqueue(i)
    for i in range(3):
        print  myqueue.dequeue()
    for i in range(5):
        myqueue.enqueue(i)
    for i in range(7):
        print myqueue.dequeue()

        



