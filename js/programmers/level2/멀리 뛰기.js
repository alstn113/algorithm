function solution(n) {
  // n === 2 경우는 2, 1+1이 가능
  if (n === 1 || n === 2) return n;
  return (solution(n - 2) + solution(n - 1)) % 1234567;
}

console.log(solution(4));
console.log(solution(3));
