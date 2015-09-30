#include <vector>
#include <string>
using namespace std;

class Solution {
public:
	vector<int> diffWaysToCompute(string input) {
		vector<int> re;
		if (input.empty()) {
			return re;
		}
		for (int i = 0; i < input.size(); i++) {
			if (input[i] == '+' || input[i] == '-' || input[i] == '*') {
				vector<int> left = diffWaysToCompute(input.substr(0, i));
				vector<int> right = diffWaysToCompute(input.substr(i + 1, input.size() - i - 1));
				for (int l : left) {
					for (int r : right) {
						if (input[i] == '+') re.push_back(l + r);
						else if (input[i] == '-') re.push_back(l - r);
						else re.push_back(l * r);
					}
				}
			}
		}
		if (re.size() == 0) re.push_back(stoi(input));
		return re;
	}
};

int main(int argc, char const *argv[])
{
	Solution sol;
	vector<int> re = sol.diffWaysToCompute("1+1");
	for (int i : re) {
		printf("%d\n", i);
	}
	return 0;
}