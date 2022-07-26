function solution(N, stages) {
  const usersPerStage = new Array(N + 1).fill(0);
  let userCnt = 0;
  const failureRates = [];
  for (let stage of stages) {
    usersPerStage[stage - 1] += 1;
    userCnt += 1;
  }
  for (let i = 0; i < usersPerStage.length - 1; i++) {
    failureRates.push([usersPerStage[i] / userCnt, i]);
    userCnt -= usersPerStage[i];
  }
  failureRates.sort((a, b) => {
    // 실패율 내림차순
    if (a[0] < b[0]) return 1;
    else if (a[0] > b[0]) return -1;
    // stage 오름차순
    else if (a[1] > b[1]) return 1;
    else if (a[1] < b[1]) return -1;
  });
  return failureRates.map((v) => {
    return v[1] + 1;
  });
}

console.log(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]));
console.log(solution(4, [4, 4, 4, 4, 4]));
