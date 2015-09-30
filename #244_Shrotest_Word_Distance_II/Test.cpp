#include <string>
#include <unordered_map>
#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
	// unordered_map<string, string> mymap;

	// mymap["Bakery"]="Barbara";  // new element inserted
	// mymap["Seafood"]="Lisa";    // new element inserted
	// mymap["Produce"]="John";    // new element inserted

	unordered_map<string, string> dic;
	dic["deli"] = "bdd";
	string name = dic["good"];
	// string name = "Good";
	cout << name << endl;
	return 0;
}