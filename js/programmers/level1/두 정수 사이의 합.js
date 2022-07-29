function sum(n) {
  return (n * (n + 1)) / 2;
}

function solution(a, b) {
  return a > b ? sum(a) - sum(b - 1) : sum(b) - sum(a - 1);
}

console.log(solution(3, 5));
console.log(solution(3, 3));
console.log(solution(5, 3));
