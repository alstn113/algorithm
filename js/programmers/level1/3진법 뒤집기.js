function solution(n) {
  let bin = n.toString(3).split('').reverse().join('');
  return parseInt(bin, 3);
}

console.log(solution(45));
console.log(solution(125));
