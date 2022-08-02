function solution(num) {
  let cnt = 0;
  while (num != 1 && cnt < 500) {
    num = num % 2 == 0 ? num / 2 : num * 3 + 1;
    cnt++;
  }
  return num == 1 ? cnt : -1;
}
console.log(solution(6));
console.log(solution(10));
console.log(solution(626331));
