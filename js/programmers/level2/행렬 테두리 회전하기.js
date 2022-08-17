function solution(rows, columns, queries) {
  const array = new Array(rows)
    .fill(0)
    .map((_, r) =>
      new Array(columns).fill(0).map((_, c) => r * columns + c + 1),
    );
  const result = [];
  for (let i = 0; i < queries.length; i++) {
    const [x1, y1, x2, y2] = queries[i].map((v) => v - 1);
    let min = array[x1][y1];
    let tmp = array[x1][y1];
    for (let i = x1; i < x2; i++) {
      array[i][y1] = array[i + 1][y1];
      min = array[i][y1] < min ? array[i][y1] : min;
    }
    for (let i = y1; i < y2; i++) {
      array[x2][i] = array[x2][i + 1];
      min = array[x2][i] < min ? array[x2][i] : min;
    }
    for (let i = x2; i > x1; i--) {
      array[i][y2] = array[i - 1][y2];
      min = array[i][y2] < min ? array[i][y2] : min;
    }
    for (let i = y2; i > y1; i--) {
      array[x1][i] = array[x1][i - 1];
      min = array[x1][i] < min ? array[x1][i] : min;
    }

    array[x1][y1 + 1] = tmp;
    result.push(min);
    console.log(array);
  }
  return result;
}

// console.log(
//   solution(6, 6, [
//     [2, 2, 5, 4],
//     [3, 3, 6, 6],
//     [5, 1, 6, 3],
//   ]),
// );
console.log(
  solution(3, 3, [
    [1, 1, 2, 2],
    [1, 2, 2, 3],
    [2, 1, 3, 2],
    [2, 2, 3, 3],
  ]),
);
// console.log(solution(100, 97, [[1, 1, 100, 97]]));
