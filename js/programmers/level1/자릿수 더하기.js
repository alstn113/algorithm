function solution(n) {
  return String(n)
    .split('')
    .reduce((acc, cur) => acc + Number(cur), 0);
}

console.log(solution(123));
