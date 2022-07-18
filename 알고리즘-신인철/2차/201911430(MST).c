#include <stdio.h>
#include <stdlib.h>

#define MAX 5

typedef struct edge {
  int u, v, w;
} edge;

typedef struct edge_list {
  edge data[MAX * MAX];
  int n;
} edge_list;

int Graph[MAX][MAX], n;
int parent[MAX], cno1, cno2;
edge_list elist;

int find_parent(int parent[], int x) {
  if (parent[x] != x) {
    parent[x] = find_parent(parent, parent[x]);
  }
  return parent[x];
}

void union_parent(int parent[], int a, int b) {
  a = find_parent(parent, a);
  b = find_parent(parent, b);
  if (a < b)
    parent[b] = a;
  else
    parent[a] = b;
}


void sort() {
  int i, j;
  edge temp;

  for (i = 1; i < elist.n; i++)
    for (j = 0; j < elist.n - 1; j++)
      if (elist.data[j].w > elist.data[j + 1].w) {
        temp = elist.data[j];
        elist.data[j] = elist.data[j + 1];
        elist.data[j + 1] = temp;
      }
}

int main() {
  elist.n = 0;

  FILE *fp = fopen("input.txt", "r");
  for (int i = 0; i < MAX; i++) {
    for (int j = 0; j < MAX; j++) {
      fscanf(fp, "%d", &Graph[i][j]);
    }
  }
  fclose(fp);

  for (int i = 0; i < MAX; i++) {
    for (int j = 0; j < MAX; j++) {
      if (i < j && Graph[i][j] != 0) {
        elist.data[elist.n].u = i;
        elist.data[elist.n].v = j;
        elist.data[elist.n].w = Graph[i][j];
        elist.n++;
      }
      Graph[i][j] = 0;
    }
  }
  sort();

  for (int i = 0; i < MAX; i++)
    parent[i] = i;

  for (int i = 0; i < elist.n; i++) {
    int a = elist.data[i].u;
    int b = elist.data[i].v;
    if (find_parent(parent, a) != find_parent(parent, b)) {
      Graph[a][b] = elist.data[i].w;
      Graph[b][a] = elist.data[i].w;
      
      union_parent(parent, a, b);
    }
  }

  for (int i = 0; i < MAX; i++) {
    for (int j = 0; j < MAX; j++) {
      printf("%d ", Graph[i][j]);
    }
    printf("\n");
  }
}