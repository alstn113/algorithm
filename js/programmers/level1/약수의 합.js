function solution(n) {
  let sum = 0;
  for (let i = 1; i <= Math.sqrt(n); i++) {
    if (i ** 2 == n) sum += i;
    else if (n % i == 0) sum += i + n / i;
  }
  return sum;
}

console.log(solution(12));
console.log(solution(5));
