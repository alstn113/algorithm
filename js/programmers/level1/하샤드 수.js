function solution(x) {
  const sum = String(x)
    .split('')
    .map(Number)
    .reduce((acc, cur) => acc + cur);
  return x % sum === 0;
}

console.log(solution(12));
console.log(solution(13));
