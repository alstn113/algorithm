function solution(new_id) {
  // 1
  new_id = new_id.toLowerCase();

  // 2
  let answer = '';
  for (let s of new_id) {
    if ('abcdefghijklmnopqrstuvwuxyz1234567890_-.'.includes(s)) {
      answer += s;
    }
  }

  // 3
  while (answer.includes('..')) {
    answer = answer.replace('..', '.');
  }

  // 4
  if (answer[0] === '.') {
    answer = answer.slice(1);
  }
  if (answer[answer.length - 1] === '.') {
    answer = answer.slice(0, -1);
  }

  // 5
  if (answer === '') {
    answer = 'a';
  }

  // 6
  answer = answer.slice(0, 15);
  if (answer[answer.length - 1] === '.') {
    answer = answer.slice(0, -1);
  }

  // 7
  while (answer.length <= 2) {
    answer += answer[answer.length - 1];
  }
  return answer;
}

console.log(solution('...!@BaT#*..y.abcdefghijklm'));
console.log(solution('z-+.^.'));
console.log(solution('=.='));
console.log(solution('123_.def'));
console.log(solution('abcdefghijklmn.p'));
