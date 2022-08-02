function solution(n) {
  const s = Math.sqrt(n);
  return s === parseInt(s) ? Math.pow(s + 1, 2) : -1;
}

console.log(solution(121));
