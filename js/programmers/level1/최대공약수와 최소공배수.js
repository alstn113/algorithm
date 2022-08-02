// 최대공약수
function calcGCD(n, m) {
  if (m == 0) return n;
  return n > m ? calcGCD(m, n % m) : calcGCD(n, m % n);
}

function solution(n, m) {
  const gcd = calcGCD(n, m);
  const lcm = (n * m) / gcd;
  return [gcd, lcm];
}

console.log(solution(3, 12));
console.log(solution(2, 5));
