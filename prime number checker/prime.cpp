#include <iostream>

using namespace std;

int main()
{
	int even[10] = {2,4,6,8,10,12,14,16,18,20};
	int odd[10] = {1,3,5,7,9,11,13,15,17,19};
	string animal[10] = {"dog", "cat", "bear", "fish", "lion", "bird", "snake", "butterfly", "frog", "tiger"};
	int num[10] = {5,34,24,43,8,19,53,59,10,11};
	// for loop
	for(int i=0; i<10; i++){
		cout << even[i] << " ";
	}
	cout << "\n";
	// while loop
	int j=0;
	while (j<10){
		cout << odd[j] << " ";
		j++;
	}
	cout << "\n";
	// do-while loop
	int k=0;
	do {
		cout << animal[k] << " ";
		k++;
	} while (k<10);
	cout << "\n" << endl;
	// prime number checker	
	cout << "EVEN, ODD, AND PRIME NUMBER CHECKER\n" << endl;
	int flag=0;
	for (int j=0; j<10; j++){
		int n=num[j];
		if(n%2==0){
			for(int i=2; i<n; i++){
			if(n%i==0){
				flag++;
				break;
			}
		}
		if(flag==0){
			cout << n << " is an even and prime number." << endl;
		}
		else {
			cout << n << " is an even number." << endl;
		} 
		}
	}
	return 0;
}
