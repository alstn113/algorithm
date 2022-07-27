function solution(d, budget) {
  d.sort((a, b) => a - b);
  let cnt = 0;
  for (let i = 0; i < d.length; i++) {
    if (budget - d[i] >= 0) {
      budget -= d[i];
      cnt += 1;
    }
  }
  return cnt;
}

console.log(solution([1, 3, 2, 5, 4], 9));
console.log(solution([2, 2, 3, 3], 10));
