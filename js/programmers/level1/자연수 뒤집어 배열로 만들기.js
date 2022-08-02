function solution(n) {
  return String(n).split('').map(Number).reverse();
}

console.log(solution(12345));
