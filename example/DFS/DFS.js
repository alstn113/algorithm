const graph = [[], [2, 3, 8], [1, 7], [1, 4, 5], [3, 5], [3, 4], [7], [2, 6, 8], [1, 7]];
// 각 인덱스에 연결된 노드
const visited = Array(9).fill(false);
let result = "";

dfs(graph, 1, visited);
console.log(result);

function dfs(graph, v, visited) {
  visited[v] = true;
  result += `${v} `;
  for (i of graph[v]) {
    if (!visited[i]) dfs(graph, i, visited);
    // 그 노드가 방문하지 않은 노드인면 dfs 재귀
  }
}
