function solution(n) {
  const dp = new Array(60000).fill(0);
  dp[1] = 1;
  dp[2] = 2;
  for (let i = 3; i <= n; i++) {
    dp[i] = (dp[i - 1] % 1000000007) + (dp[i - 2] % 1000000007);
  }
  return dp[n] % 1000000007;
}

console.log(solution(4));
