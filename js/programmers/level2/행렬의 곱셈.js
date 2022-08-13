function solution(arr1, arr2) {
  const result = [];
  const [N, M] = [arr1.length, arr2[0].length];
  for (let i = 0; i < N; i++) {
    const tmp = [];
    for (let j = 0; j < M; j++) {
      let sum = 0;
      for (let k = 0; k < M; k++) {
        sum += arr1[i][k] * arr2[k][j];
      }
      tmp.push(sum);
    }
    result.push(tmp);
  }
  return result;
}

console.log(
  solution(
    [
      [1, 4],
      [3, 2],
      [4, 1],
    ],
    [
      [3, 3],
      [3, 3],
    ],
  ),
);
console.log(
  solution(
    [
      [2, 3, 2],
      [4, 2, 4],
      [3, 1, 4],
    ],
    [
      [5, 4, 3],
      [2, 4, 1],
      [3, 1, 1],
    ],
  ),
);
