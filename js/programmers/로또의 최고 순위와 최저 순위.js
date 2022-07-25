function solution(lottos, win_nums) {
  let correct = 0;
  let zero = 0;
  for (let num of lottos) {
    if (num === 0) {
      zero += 1;
      continue;
    }
    if (win_nums.includes(num)) {
      correct += 1;
    }
  }
  return [
    zero + correct === 0 ? 6 : Math.abs(zero + correct - 7),
    correct === 0 ? 6 : Math.abs(correct - 7),
  ];
}

console.log(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]));
console.log(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]));
console.log(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]));
