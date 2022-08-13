function solution(n) {
  let answer = 0;
  for (let i = 1; i < n; i++) {
    sum = i;
    num = i + 1;
    while (sum < n) {
      sum += num;
      num += 1;
    }
    if (sum === n) {
      answer += 1;
    }
  }
  // n = n인 경우가 있으므로 +1
  return answer + 1;
}

console.log(solution(15));
