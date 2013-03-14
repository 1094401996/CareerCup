class queue:
    def __init__(self,capacity= 16):
        self.queue = []
        self.capacity = capacity
        self.size = 0
    def isEmpty(self):
        return self.size == 0
    def isFull(self):
        return self.size == self.capacity
    def getFront(self):
        if self.isEmpty():
            raise Exception("queueisempty")
        else:
            return self.queue[0]
    def getRear(self):
        if self.isEmpty():
            raise Exception("queueisempty")
        else:
            return self.queue[size - 1]
    def enqueue(self,element):
        if self.isFull():
            raise Excetption("queueisfull")
        else:
            self.queue.append(element)
            self.size += 1
    def dequeue(self):
        if self.isEmpty():
            raise Exception("queueisemtpy")
        else:
            self.queue.pop(0)
            self.size -= 1
    def printall(self):
        print (self.queue)
    def getsize(self):
        return self.size

if __name__ == "__main__":
    myqueue = queue()
    for i in range(5):
        myqueue.enqueue(i)
    for i in range(3):
        myqueue.dequeue()
    myqueue.printall()
    print myqueue.getsize()
       
       
 

