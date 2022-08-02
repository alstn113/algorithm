function solution(x, n) {
  return new Array(n).fill(1).map((cur, idx) => cur * ((idx + 1) * x));
}

console.log(solution(2, 5));
console.log(solution(4, 3));
console.log(solution(-4, 2));
