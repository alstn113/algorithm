function solution(n) {
  let result = '';
  while (n != 0) {
    a = parseInt(n / 3);
    b = n % 3;
    if (b == 0) {
      a -= 1;
      result = '4' + result;
    } else if (b == 1) {
      result = '1' + result;
    } else if (b == 2) {
      result = '2' + result;
    }
    n = a;
  }
  return result;
}

console.log(solution(10));
