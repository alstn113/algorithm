function solution(s) {
  return s.length % 2 == 0
    ? s.slice(s.length / 2 - 1, s.length / 2 + 1)
    : s.slice(s.length / 2, s.length / 2 + 1);
}

console.log(solution('abcde'));
console.log(solution('qwer'));
