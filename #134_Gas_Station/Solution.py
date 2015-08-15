class Solution:
	# @param {integer[]} gas
	# @param {integer[]} cost
	# @return {integer}
	def canCompleteCircuit(self, gas, cost):
		if not len(gas) or not len(cost):
			return -1
		if len(gas) != len(cost):
			return -1
		index = 0
		while index < len(gas):  # don't mod index ever
			r = 0
			cur = index
			step = 0
			while r + gas[cur] >= cost[cur]:
				step += 1
				r = r + gas[cur] - cost[cur]
				cur = (cur + 1) % len(gas)
				if step == len(gas):
					return index
			if index + step >= len(gas):
				return -1
			index += step + 1    # new index
		return -1

gas = [5]
cost = [4]
sol = Solution()
print sol.canCompleteCircuit(gas, cost)