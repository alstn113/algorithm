function solution(s) {
  let answer = '';
  s = s.toLowerCase();
  for (let i = 0; i < s.length; i++) {
    if (i === 0 || s[i - 1] === ' ') {
      answer += s[i].toUpperCase();
      continue;
    }
    answer += s[i];
  }
  return answer;
}

console.log(solution('3people unFollowed me'));
console.log(solution('for the last week'));
console.log(solution('  for    the last week'));
