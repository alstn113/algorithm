function solution(sizes) {
  let s1 = 0;
  let s2 = 0;
  for (let size of sizes) {
    if (size[0] >= size[1]) {
      s1 = Math.max(s1, size[0]);
      s2 = Math.max(s2, size[1]);
    } else {
      s1 = Math.max(s1, size[1]);
      s2 = Math.max(s2, size[0]);
    }
  }

  return s1 * s2;
}

console.log(
  solution([
    [60, 50],
    [30, 70],
    [60, 30],
    [80, 40],
  ]),
);
console.log(
  solution([
    [10, 7],
    [12, 3],
    [8, 15],
    [14, 7],
    [5, 15],
  ]),
);
console.log(
  solution([
    [14, 4],
    [19, 6],
    [6, 16],
    [18, 7],
    [7, 11],
  ]),
);
