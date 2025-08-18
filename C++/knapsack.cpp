#include<iostream>
#include<algorithm>
using namespace std;

double algo(double profit[], double weight[], double bag, int n){
    double ratio[n];
    for(int i = 0; i < n; i++){
        ratio[i] = profit[i]/weight[i];
    }
    
    for(int i = 0; i < n-1; i++){
        for(int j = 0; j < n-1-i; j++){
            if(ratio[j] > ratio[j+1]){
                swap(ratio[j],ratio[j+1]);
                swap(profit[j],profit[j+1]);
                swap(weight[j],weight[j+1]);
            }
        }
    }
    
    double amount = 0;
    for(int i = n-1; i >=0; i--){
    
        if(weight[i] <= bag){
            amount+= profit[i];
            bag-= weight[i];
        }else{
            amount+= bag*ratio[i];
            break;
        }
        
    }
    
    return amount;
    
}

int main(){
    int n = 5;
    double knacksap = 5;
    double value[] = {500,100,120,60,20};
    double weight[] = {10,2,1,1,1};
    
    cout << algo(value,weight,knacksap,n);
    
    
    
}