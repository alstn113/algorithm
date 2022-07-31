function isPrime(n) {
  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i == 0) return 0;
  }
  return 1;
}

function solution(n) {
  let cnt = 0;
  for (let i = 2; i <= n; i++) {
    cnt += isPrime(i);
  }

  return cnt;
}

console.log(solution(10));
console.log(solution(5));
