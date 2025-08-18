#include <iostream>
#include<algorithm>
using namespace std;


int partition(int arr[], int low, int high){
    int pivot = arr[high];
    int i = low-1;
    for(int j = low; j < high ;j++){
        if(arr[j] < pivot){
            i++;
            swap(arr[i],arr[j]);
        }
    }
    
    swap(arr[i+1],arr[high]);
    return i+1;
    
}

void quicksort(int arr[],int low, int high){
    if(low < high){
        int pivot = partition(arr,low,high);
        quicksort(arr,low,pivot-1);
        quicksort(arr,pivot+1,high);
    }
}

int main() {
    
    int arr[] = {5,1,9,2,8};
    int n = 5;
     for(int i : arr){
        cout<< i <<" ";
    }
    
    cout << endl;
    
    quicksort(arr,0,n-1);
    
     for(int i : arr){
        cout<< i <<" ";
    }

    return 0;
}