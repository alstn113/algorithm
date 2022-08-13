function solution(s) {
  const array = [];
  for (let i = 0; i < s.length; i++) {
    if (array.length > 0 && array[array.length - 1] === s[i]) {
      array.pop();
      continue;
    }
    array.push(s[i]);
  }

  return array.length ? 0 : 1;
}

console.log(solution('baabaa'));
console.log(solution('cdcd'));
