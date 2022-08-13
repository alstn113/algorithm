function solution(n) {
  let [a, b] = [0, 1];
  for (let i = 2; i <= n; i++) {
    [a, b] = [b % 1234567, (a + b) % 1234567];
  }
  return b % 1234567;
}

console.log(solution(3));
console.log(solution(5));
