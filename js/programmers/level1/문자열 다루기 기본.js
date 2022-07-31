function solution(s) {
  let cnt = 0;
  for (let i = 0; i < s.length; i++) {
    if (!'1234567890'.includes(s[i])) return false;
    cnt += 1;
    if (cnt > 6) return false;
  }
  return cnt === 4 || cnt === 6;
}

console.log(solution('a234'));
console.log(solution('1234'));
