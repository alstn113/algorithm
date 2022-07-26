function solution(numbers) {
  let result = 45;
  numbers.forEach((v) => {
    result -= v;
  });
  return result;
}

console.log(solution([1, 2, 3, 4, 6, 7, 8, 0]));
console.log(solution([5, 8, 4, 0, 6, 7, 9]));
