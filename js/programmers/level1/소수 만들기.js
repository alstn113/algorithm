function isPrime(n) {
  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i == 0) return 0;
  }
  return 1;
}
function solution(nums) {
  const len = nums.length;
  let cnt = 0;
  for (let i = 0; i < len - 2; i++)
    for (let j = i + 1; j < len - 1; j++)
      for (let k = j + 1; k < len; k++)
        cnt += isPrime(nums[i] + nums[j] + nums[k]);

  return cnt;
}

console.log(solution([1, 2, 3, 4]));
console.log(solution([1, 2, 7, 6, 4]));
