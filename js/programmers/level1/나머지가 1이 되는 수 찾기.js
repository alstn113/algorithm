function solution(n) {
  for (let i = 0; i < n; i++) {
    if (n % i == 1) {
      return i;
    }
  }
}

console.log(solution(10));
console.log(solution(12));
