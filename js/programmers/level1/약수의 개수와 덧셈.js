function divisor(n) {
  let cnt = 0;
  for (let i = 1; i <= Math.sqrt(n); i++) {
    if (i ** 2 == n) {
      cnt += 1;
    } else if (n % i == 0) {
      cnt += 2;
    }
  }
  return cnt % 2 == 0 ? n : -n;
}

function solution(left, right) {
  let answer = 0;
  for (let i = left; i <= right; i++) {
    answer += divisor(i);
  }

  return answer;
}

console.log(solution(13, 17));
console.log(solution(24, 27));
