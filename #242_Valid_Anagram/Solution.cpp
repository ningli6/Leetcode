#include <string>
#include <unordered_map>
#include <iostream>
using namespace std;

class Solution {
public:
	bool isAnagram(string s, string t) {
		if (s.empty() && t.empty()) {
			return true;
		}
		if (s.size() != t.size()) {
			return false;
		}
		if (s.size() != t.size()) {
			return false;
		}
		unordered_map<char, int> sMap;
		for (int i = 0; i < s.size(); i++) {
			sMap[s[i]] = sMap[s[i]] + 1;
		}
		unordered_map<char, int> tMap;
		for (int i = 0; i < s.size(); i++) {
			tMap[t[i]] = tMap[t[i]] + 1;
		}
		return sMap == tMap;
	}
};

int main(int argc, char const *argv[])
{
	Solution sol;
	string s = "a";
	string t = "b";
	printf("%s\n", sol.isAnagram(s, t) ? "true" : "false");
	return 0;
}