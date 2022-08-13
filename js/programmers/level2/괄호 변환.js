function balanceString(s) {
  let l = 0,
    r = 0;

  for (let i = 0; i < s.length; i++) {
    if (s[i] === '(') l += 1;
    else r += 1;
    if (l === r) return [s.slice(0, l + r), s.slice(l + r)];
  }
}

function isCorrectString(s) {
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

function change(s) {
  let result = '';
  for (let i = 1; i < s.length - 1; i++) {
    if (s[i] === '(') result += ')';
    else result += '(';
  }
  return result;
}

function solution(p) {
  // 1단계
  if (p === '') return '';
  if (isCorrectString(p)) return p;
  let [u, v] = balanceString(p);
  // 3단계
  if (isCorrectString(u)) {
    return u + solution(v);
  }
  // 4단계
  else {
    return '(' + solution(v) + ')' + change(u);
  }
}

console.log(solution('(()())()'));
console.log(solution(')('));
console.log(solution('()))((()'));
