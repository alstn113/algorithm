// 프로그래머스 레벨2 [게임 맵 최단거리]

function solution(maps) {
  N = maps.length;
  M = maps[0].length;
  dx = [-1, 1, 0, 0];
  dy = [0, 0, -1, 1];
  queue = [[0, 0]];
  while (queue.length !== 0) {
    [x, y] = queue.shift();
    for (let i = 0; i < 4; i++) {
      nx = x + dx[i];
      ny = y + dy[i];
      if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
      if (maps[nx][ny] === 0) continue;
      if (maps[nx][ny] === 1) {
        maps[nx][ny] = maps[x][y] + 1;
        queue.push([nx, ny]);
      }
    }
  }
  return maps[N - 1][M - 1] === 1 ? -1 : maps[N - 1][M - 1];
}

console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 1],
    [0, 0, 0, 0, 1],
  ]),
);
console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 0],
    [0, 0, 0, 0, 1],
  ]),
);
