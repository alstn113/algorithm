function solution(n, lost, reserve) {
  let answer = 0;
  const array = new Array(n).fill(1);
  lost.forEach((v) => (array[v - 1] -= 1));
  reserve.forEach((v) => (array[v - 1] += 1));

  for (let i = 0; i < array.length; i++) {
    if (i > 0 && array[i] == 2 && array[i - 1] == 0) {
      array[i] = 1;
      array[i - 1] = 1;
      answer += 2;
    } else if (i < array.length - 1 && array[i] == 2 && array[i + 1] == 0) {
      console.log('ar', array[i]);
      array[i] = 1;
      array[i + 1] = 1;
      answer += 2;
      i++;
    } else if (array[i] !== 0) {
      answer += 1;
    }
  }
  return answer;
}

console.log(solution(5, [2, 4], [1, 3, 5]));
console.log(solution(5, [2, 4], [3]));
console.log(solution(3, [3], [1]));
