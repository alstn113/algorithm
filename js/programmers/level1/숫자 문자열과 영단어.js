function solution(s) {
  while (isNaN(Number(s))) {
    s = s
      .replace('zero', 0)
      .replace('one', 1)
      .replace('two', 2)
      .replace('three', 3)
      .replace('four', 4)
      .replace('five', 5)
      .replace('six', 6)
      .replace('seven', 7)
      .replace('eight', 8)
      .replace('nine', 9);
  }
  return Number(s);
}

console.log(solution('one4seveneight'));
console.log(solution('23four5six7'));
console.log(solution('2three45sixseven'));
console.log(solution('123'));
