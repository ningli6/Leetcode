#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

class WordDistance {
private:
	unordered_map<string, vector<int> > dic;
public:
	WordDistance(vector<string> words) {
        for (int i = 0; i < words.size(); i++) {
        	dic[words[i]].push_back(i);
        }
    }

    int shortest(string word1, string word2) {
        vector<int> list1 = dic[word1];
        vector<int> list2 = dic[word2];
        int re = INT_MAX;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
        	if (list1[i] < list2[j]) {
        		re = min(re, list2[j] - list1[i]);
        		i++;
        	}
        	else {
        		re = min(re, list1[i] - list2[j]);
        		j++;
        	}
        }
        return re;
    }
};

int main(int argc, char* argv[]) {
	string str[] = {"practice", "makes", "perfect", "coding", "makes"};
	vector<string> s(str, str + sizeof(str) / sizeof(*str));
	WordDistance wd(s);
	printf("%d\n", wd.shortest("coding", "makes"));
}