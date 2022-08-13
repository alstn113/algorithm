function solution(n) {
  const dp = new Array(2000).fill(0);
  dp[1] = 1;
  dp[2] = 2;
  for (let i = 3; i <= n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
  }
  return dp[n] % 1234567;
}

console.log(solution(4));
console.log(solution(3));
