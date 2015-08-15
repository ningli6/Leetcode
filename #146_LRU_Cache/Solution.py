'''
constant time for get and set
'''

# Doubly list node
class DlinkedNode():
	def __init__(self, key, val):
		self.key = key
		self.val = val
		self.prev = None
		self.next = None

# Doubly linked list, left side is the oldest end, right side is the newest end
class DlinkedList:
	def __init__(self):
		self.head = DlinkedNode(-1, 0)
		self.tail = DlinkedNode(-1, 0)
		self.head.next = self.tail
		self.tail.prev = self.head

	# add the node to the last
	# @param {DlinkedNode} node
	def addLast(self, node):
		prevNode = self.tail.prev
		nextNode = self.tail
		prevNode.next = node
		node.prev = prevNode
		nextNode.prev = node
		node.next = nextNode

	# delete the node from the list
	# @param {DlinkedNode} node
	def delete(self, node):
		prevNode = node.prev
		nextNode = node.next
		prevNode.next = nextNode
		nextNode.prev = prevNode
		node.prev = None
		node.next = None

	# remove the first(oldest element) in the list, return Null if list is empty
	def popLeft(self):
		if self.head.next is self.tail:
			return None
		rm = self.head.next
		self.delete(rm)
		return rm

class LRUCache:
	# @param capacity, an integer
	def __init__(self, capacity):
		self.capacity = capacity
		self.size = 0
		self.list = DlinkedList()
		self.cache = {} # key, listNode pair

	# @return an integer
	def get(self, key):
		if key not in self.cache:
			return -1
		node = self.cache[key]
		self.list.delete(node)
		self.list.addLast(node)
		return node.val

	# @param key, an integer
	# @param value, an integer
	# @return nothing
	def set(self, key, value):
		if key in self.cache:
			node = self.cache[key]
			node.val = value
			self.list.delete(node)
			self.list.addLast(node)
			return
		newNode = DlinkedNode(key, value)
		self.cache[key] = newNode
		self.list.addLast(newNode)
		self.size += 1
		if self.size > self.capacity:
			rm = self.list.popLeft()
			if not rm:
				return
			del self.cache[rm.key]
			self.size -= 1

sol = LRUCache(5)
sol.set(1, 1)
sol.set(2, 2)
sol.set(3, 3)
sol.set(4, 4)
sol.set(5, 5)
print sol.get(1)
sol.set(6, 6)
print sol.get(2)