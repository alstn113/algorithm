function solution(s) {
  const r = s
    .split(' ')
    .map(Number)
    .sort((a, b) => a - b);
  return `${r[0]} ${r[r.length - 1]}`;
}

console.log(solution('1 2 3 4'));
console.log(solution('-1 -2 -3 -4'));
console.log(solution('-1 -1'));
