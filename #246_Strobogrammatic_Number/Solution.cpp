#include <iostream>
#include <string>

using namespace std;

class Solution
{
public:
	bool isStrobogrammatic(string num) {
		if (num.size() == 0) return true;
		int i = 0, j = num.size() - 1;
		while (i <= j) {
			if ((num[i] == '1' && num[j] == '1')
				|| (num[i] == '8' && num[j] == '8')
				|| (num[i] == '0' && num[j] == '0')
				|| (num[i] == '6' && num[j] == '9')
				|| (num[i] == '9' && num[j] == '6')) {
				i++; j--;
			}
			else {
				return false;
			}
		}
		return true;
	}
};

int main(int argc, char const *argv[])
{
	Solution sol;
	printf("%d\n", sol.isStrobogrammatic("8"));
	return 0;
}