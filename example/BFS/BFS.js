const graph = [[], [2, 3, 8], [1, 7], [1, 4, 5], [3, 5], [3, 4], [7], [2, 6, 8], [1, 7]];
// 각 인덱스에 연결된 노드
const visited = Array(9).fill(false);
let result = "";

bfs(graph, 1, visited);
console.log(result);

function bfs(graph, start, visited) {
  const queue = [start];
  visited[start] = true;
  while (queue.length !== 0) {
    v = queue.shift();
    result += `${v} `;
    for (i of graph[v]) {
      if (!visited[i]) {
        queue.push(i);
        visited[i] = true;
      }
    }
  }
}
