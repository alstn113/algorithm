function check(str, slice_len) {
  const array = [];
  const len = parseInt(str.length / slice_len);
  const t = str.length % slice_len;

  for (let i = 0; i < len; i++) {
    array.push(str.slice(i * slice_len, i * slice_len + slice_len));
  }

  let result = 0;
  let cnt = 1;
  for (let i = 1; i < len; i++) {
    if (array[i - 1] === array[i]) {
      cnt += 1;
    } else {
      result += cnt === 1 ? slice_len : slice_len + String(cnt).length;
      cnt = 1;
    }
  }
  result += cnt === 1 ? slice_len : slice_len + String(cnt).length;

  return result + t;
}

function solution(s) {
  const len = s.length;
  const array = [len];
  for (let i = 1; i < len; i++) {
    array.push(check(s, i));
  }
  return Math.min(...array);
}

console.log(solution('aabbaccc'));
console.log(solution('ababcdcdababcdcd'));
console.log(solution('abcabcdede'));
console.log(solution('abcabcabcabcdededededede'));
console.log(solution('xababcdcdababcdcd'));
console.log(solution('aaaaaaaaaaaabcd')); // 6
console.log(solution('xxxxxxxxxxyyy')); // 5
