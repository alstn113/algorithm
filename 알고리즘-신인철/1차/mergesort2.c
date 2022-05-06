#include <stdio.h>

void merge2(int S[], int low, int mid, int high) {
  int i = low;
  int j = mid + 1;
  int k = 0;
  int U[high - low + 1];
  while (i <= mid && j <= high) {
    if (S[i] < S[j]) {
      U[k] = S[i];
      i++;
    } else {
      U[k] = S[j];
      j++;
    }
    k++;
  }
  if (i > mid) {
    while (j <= high) {
      U[k] = S[j];
      j++;
      k++;
    }
  } else {
    while (i <= mid) {
      U[k] = S[i];
      i++;
      k++;
    }
  }
  k = 0;
  while (low + k <= high) {
    S[low + k] = U[k];
    k++;
  }
}

void mergesort2(int S[], int low, int high) {
  int mid;
  if (low < high) {
    mid = (low + high) / 2;
    mergesort2(S, low, mid);
    mergesort2(S, mid + 1, high);
    merge2(S, low, mid, high);
  }
}

int main(void) {
  int S[] = {11, 4, 5, 23, 7, 1};
  int size = sizeof(S) / sizeof(int);
  mergesort2(S, 0, size - 1);

  for (int i = 0; i < size; i++) {
    printf("%d ", S[i]);
  }
  return 0;
}