function solution(s) {
  let answer = '';
  let cnt = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] === ' ') {
      cnt = 0;
      answer += ' ';
      continue;
    }
    answer += cnt & 1 ? s[i].toLowerCase() : s[i].toUpperCase();
    cnt += 1;
  }
  return answer;
}

console.log(solution('try hello world'));
