function solution(s) {
  let l = 0,
    r = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] === '(') l += 1;
    else r += 1;
    if (r > l) return false;
  }
  if (l !== r) return false;
  return true;
}

console.log(solution('()()'));
console.log(solution('(())()'));
console.log(solution(')()('));
console.log(solution('(()('));
