import random #난수생성 라이브러리
import timeit #시간 측정을 위한 라이브러리

class Node: # 자신의 값과 왼쪽, 오른쪽 자식을 갖는 Node라는 클래스 생성 
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        
class BST: # BST
    def __init__(self): # 해당 클래스의 node와 root를 none으로 초기화
        self.node =None
        self.root = None

        
    def setRoot(self, val): # root가 없을 때 root를 생성
        self.root = Node(val)
    
    def find(self, val): #탐색하는 함수, 해당 노드가 존재하면 True, 아니면 False를 return
        if (self.findNode(self, val) is False):
            return False
        else:
            return True

    def findNode(self, currentNode,val): # 탐색하는 함수, 재귀 호출을 하며 루트부터 비교며 탐색한다.
        currentNode=currentNode.node
        if (currentNode is None):
            return False
        elif (val == currentNode.val):
            return currentNode
        elif (val < currentNode.val):
            return self.findNode(currentNode.left, val)
        else:
            return self.findNode(currentNode.right, val)
        
        
    def insert(self, val): #노드를 삽입하는 함수
        tree = self.node
        newnode = Node(val)
        
        # empty tree일 경우에만 새 값을
        # empty tree의 루트(node)에 넣음
        # 이 루트의 left/right에 새 empty tree 선언
        if tree == None:
            self.node = newnode
            self.node.left = BST()
            self.node.right = BST()
            self.root=self.node

        # 현재 보고 있는 node가 비어있지 않고
        # 새 값이 현재 node의 값보다 작으면
        # 왼쪽 서브트리에 삽입 (재귀함수 호출)
        elif val < tree.val:
            self.node.left.insert(val)

        # 새 값이 현재 node의 값보다 크면
        # 오른쪽 서브트리에 삽입 (재귀함수 호출)
        elif val > tree.val:
            self.node.right.insert(val)

        else:
            print("val [" + str(val) + "] already in tree.")
        
class AVL(): #AVLzz
    def __init__(self): # 해당 클래스의 node를 none, 높이를 -1, 균형을 0으로 초기화 한다.
        self.node = None
        self.height = -1
        self.balance = 0

        self.root = None

    def setRoot(self, val): # root가 없을 때 root를 생성
        self.root = Node(val)

    def insert(self, val):
        tree = self.node
        newnode = Node(val)
        
        # empty tree일 경우에만 새 값을
        # empty tree의 루트(node)에 넣음
        # 이 루트의 left/right에 새 empty tree 선언
        if tree == None:
            self.node = newnode
            self.node.left = AVL()
            self.node.right = AVL()
            self.root=self.node

        # 현재 보고 있는 node가 비어있지 않고
        # 새 값이 현재 node의 값보다 작으면
        # 왼쪽 서브트리에 삽입 (재귀함수 호출)
        elif val < tree.val:
            self.node.left.insert(val)

        # 새 값이 현재 node의 값보다 크면
        # 오른쪽 서브트리에 삽입 (재귀함수 호출)
        elif val > tree.val:
            self.node.right.insert(val)

        else:
            print("val [" + str(val) + "] already in tree.")
        # rebalancing
        self.rebalance()

    def rebalance(self): #새로운 노드가 삽입되었으므로 균형을 맞춰주는 함수
        # val inserted. Let's check if we're balanced
        self.update_heights(False)
        self.update_balances(False)
        while self.balance < -1 or self.balance > 1: # 균형이 맞지 않을때 (절대값 1보다 많이 차이 날때)
            if self.balance > 1:  # 1보다 크면
                if self.node.left.balance < 0:
                    self.node.left.lrotate()  # we're in case II
                    self.update_heights()
                    self.update_balances()
                self.rrotate()
                self.update_heights()
                self.update_balances()

            if self.balance < -1: # -1보다 작으면
                if self.node.right.balance > 0:
                    self.node.right.rrotate()  # we're in case III
                    self.update_heights()
                    self.update_balances()
                self.lrotate()
                self.update_heights()
                self.update_balances()

    def rrotate(self): # 노드의 자리를 바꿔주는 함수
        A = self.node
        B = self.node.left.node
        T = B.right.node
        if self.root is A:
            self.root=B  
        self.node = B
        B.right.node = A
        A.left.node = T
        

    def lrotate(self): # 노드의 자리를 바꿔주는 함수
        A = self.node
        B = self.node.right.node
        T = B.left.node
        if self.root is A:
            self.root=B 
        self.node = B
        B.left.node = A
        A.right.node = T

    def update_heights(self, recurse=True): # 높이를 업데이트해주는 함수
        if not self.node == None:
            if recurse:
                if self.node.left != None:
                    self.node.left.update_heights()
                if self.node.right != None:
                    self.node.right.update_heights()

            self.height = max(self.node.left.height,
                              self.node.right.height) + 1
        else:
            self.height = -1

    def update_balances(self, recurse=True): # 균형을 업데이트 해주는 함수
        if not self.node == None:
            if recurse:
                if self.node.left != None:
                    self.node.left.update_balances()
                if self.node.right != None:
                    self.node.right.update_balances()

            self.balance = self.node.left.height - self.node.right.height
        else:
            self.balance = 0
            
    
    def find(self, val): #탐색하는 함수, 해당 노드가 존재하면 True, 아니면 False를 return
        if (self.findNode(self, val) is False):
            return False
        else:
            return True

    def findNode(self, currentNode,val): # 탐색하는 함수, 재귀 호출을 하며 루트부터 비교며 탐색한다.
        currentNode=currentNode.node
        if (currentNode is None):
            return False
        elif (val == currentNode.val):
            return currentNode
        elif (val < currentNode.val):
            return self.findNode(currentNode.left, val)
        else:
            return self.findNode(currentNode.right, val)

def height(object):
    return 1 + max(height(object.node.left) if object.node.left.node is not None else 0, 
                   height(object.node.right) if object.node.right.node is not None else 0) 

def randominsert(val):  # val의 값만큼 1부터 val+1의 값 중 unique한 값을 리스트에 val의 개수 만큼 넣어주고 반환하는 함수
    inlist=random.sample(range(1, val+1), val)
    return inlist


def findtime(object,val): # 탐색에 걸리는 시간을 측정하여 반환 함수
    num=random.randrange(1,val+1)
    start = timeit.default_timer()
    object.find(num)
    stop = timeit.default_timer()
    return stop-start
    
def insert_find(object,val): #AVL이나 BST가 들어왔을 때, 100번 random하게 val만큼 트리에 삽입해주고 탐색하여 평균 탐색시간을 계산하는 함수
    total_time=0
    total_height=0
    for i in range(100):
        if repr(type(object))==repr(type(AVL())):
            object=AVL()
        else:
            object=BST()
        random.seed()
        list=randominsert(val)
        for j in list:
            object.insert(j)
        total_time+=findtime(object,val)
        total_height+=(height(object)-1)
    average_time=total_time/100
    average_height=total_height/100
    print(str(val)+"개의\t"+ str(type(object))+"\t평균 높이: " +str(average_height) +"\t평균 탐색 시간 : "+ str(average_time) )

def main():
    start = timeit.default_timer()
    print("BST------------------------")
    for i in range(10): # 10번 반복하여 BST를 500부터 5000까지 insert_find()로 삽입하고 탑색한다.
        insert_find(BST(),500*(i+1))
    stop = timeit.default_timer()
    print(stop-start)
    start = timeit.default_timer()
    print("\n\nAVL------------------------")
    for i in range(10): # 10번 반복하여 AVL을 500부터 5000까지 insert_find()로 삽입하고 탑색한다.
        insert_find(AVL(),500*(i+1))
    stop = timeit.default_timer()
    print(stop-start)
main()