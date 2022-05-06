#include <stdio.h>

int partition(int S[], int low, int high) {
  int pivotitem = S[low];
  int j = low;
  int tmp;

  for (int i = low + 1; i <= high; i++) {
    if (S[i] < pivotitem) {
      j++;

      tmp = S[i];
      S[i] = S[j];
      S[j] = tmp;
    }
  }

  int pivotpoint = j;

  tmp = S[low];
  S[low] = S[pivotpoint];
  S[pivotpoint] = tmp;

  return pivotpoint;
}

void quicksort(int S[], int low, int high) {
  if (high > low) {
    int pivotpoint = partition(S, low, high);
    quicksort(S, low, pivotpoint - 1);
    quicksort(S, pivotpoint + 1, high);
  }
}

int main(void) {
  int S[] = {11, 4, 5, 23, 7, 1};
  int size = sizeof(S) / sizeof(int);
  quicksort(S, 0, size - 1);

  for (int i = 0; i < size; i++) {
    printf("%d ", S[i]);
  }
  return 0;
}