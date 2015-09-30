#include <vector>
#include <queue>
#include <iostream>

using namespace std;

class SlidingWindow
{
public:
	vector<int> minSlidingWindow(vector<int>& nums, int k) {
		queue<int> queue;
		vector<int> ans;
		for (int i = 0; i < nums.size(); i++) {
			if (!queue.empty() && queue.front() <= i - k) {
				queue.pop();
			}
			while (!queue.empty() && nums[queue.front()] >= nums[i]) {
				queue.pop();
			}
			queue.push(i);
			if (i >= k - 1) {
				ans.push_back(nums[queue.front()]);
			}
		}
		return ans;
	}
};

int main(int argc, char const *argv[])
{
	int array[] = {1,3,-1,-3,5,3,6,7};
	vector<int> nums (array, array + (sizeof(array) / sizeof(*array)));
	SlidingWindow sol;
	vector<int> re = sol.minSlidingWindow(nums, 2);
	for (int i = 0; i < re.size(); i++) {
		printf("%d\n", re[i]);
	}
	return 0;
}