#include <string>
#include <unordered_map>
#include <iostream>
using namespace std;

class Solution2
{
public:
	bool isAnagram(string s, string t) {
		if (s.empty() && t.empty()) {
			return true;
		}
		if (s.size() != t.size()) {
			return false;
		}
		int count[26] = {0};
		for (char c : s) {
			count[c - 'a']++;
		}
		for (char c : t) {
			count[c - 'a']--;
		}
		for (int i : count) {
			if (i != 0) return false;
		}
		return true;
	}
};


int main(int argc, char const *argv[])
{
	Solution2 sol;
	string s = "a";
	string t = "a";
	printf("%s\n", sol.isAnagram(s, t) ? "true" : "false");
	return 0;
}