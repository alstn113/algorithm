function solution(numbers) {
  const result = numbers
    .map(String)
    .sort((a, b) => Number(b + a) - Number(a + b))
    .join('');

  return result[0] === '0' ? '0' : result;
}

console.log(solution([6, 10, 2]));
console.log(solution([3, 30, 34, 5, 9]));
console.log(solution([0, 0]));
