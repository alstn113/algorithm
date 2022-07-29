function solution(arr, divisor) {
  arr = arr.filter((v) => v % divisor == 0).sort((a, b) => a - b);
  return arr.length == 0 ? [-1] : arr;
}

console.log(solution([5, 9, 7, 10], 5));
console.log(solution([2, 36, 1, 3], 1));
console.log(solution([3, 2, 6], 10));
