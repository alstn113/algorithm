function solution(a, b) {
  return a.reduce((acc, cur, i) => acc + cur * b[i], 0);
}

console.log(solution([1, 2, 3, 4], [-3, -1, 0, 2]));
console.log(solution([-1, 0, 1], [1, 0, -1]));
