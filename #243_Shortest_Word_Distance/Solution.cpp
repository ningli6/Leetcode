#include <vector>
#include <string>

using namespace std;

class Solution {
public:
	int shortestDistance(vector<string>& words, string word1, string word2) {
        int index = -1;
        int re = words.size();
        for (int i = 0; i < words.size(); i++) {
        	if (words[i] == word1 || words[i] == word2) {
        		if (index < 0 || words[i] == words[index]) {
        			index = i;
        		}
        		else {
        			re = min(re, i - index);
        			index = i;
        		}
        	}
        }
        return re;
    }
};

int main(int argc, char const *argv[]) {
	Solution sol;
	string str[] = {"practice", "makes", "perfect", "coding", "makes"};
	vector<string> words(str, str + sizeof(str) / sizeof(*str));
	printf("%d\n", sol.shortestDistance(words, "practice", "makes"));

	int a[7] = {0};
	printf("sizeof(a): %lu\n", sizeof(a));
	printf("sizeof(*a): %lu\n", sizeof(*a));
	return 0;
}