function solution(nums) {
  const canTakeCnt = nums.length / 2;
  const set = new Set(nums);
  return set.size > canTakeCnt ? canTakeCnt : set.size;
}

console.log(solution([3, 1, 2, 3]));
console.log(solution([3, 3, 3, 2, 2, 4]));
console.log(solution([3, 3, 3, 2, 2, 2]));
