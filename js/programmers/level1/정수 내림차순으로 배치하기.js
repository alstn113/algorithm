function solution(n) {
  return +String(n)
    .split('')
    .map(Number)
    .sort((a, b) => b - a)
    .join('');
}

console.log(solution(118372));
