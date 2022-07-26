function solution(dartResult) {
  const score = new Array(3).fill(0);
  let chance = -1;
  for (let i = 0; i < dartResult.length; i++) {
    // step 1
    if ('1234567890'.includes(dartResult[i])) {
      chance++;
      if (dartResult[i] == '1' && dartResult[i + 1] == '0') {
        score[chance] += 10;
        i++;
      } else {
        score[chance] += Number(dartResult[i]);
      }
      continue;
    }

    // step 2
    if (dartResult[i] == 'S') {
      score[chance] **= 1;
    } else if (dartResult[i] == 'D') {
      score[chance] **= 2;
    } else if (dartResult[i] == 'T') {
      score[chance] = score[chance] ** 3;
    }
    // step 3
    else if (dartResult[i] == '*') {
      score[chance] *= 2;
      if (chance != 0) {
        score[chance - 1] *= 2;
      }
    } else if (dartResult[i] == '#') {
      score[chance] *= -1;
    }
  }
  return score.reduce((a, b) => a + b);
}

console.log(solution('1S2D*3T'));
console.log(solution('1D2S#10S'));
console.log(solution('1D2S0T'));
console.log(solution('1S*2T*3S'));
console.log(solution('1D#2S*3S'));
console.log(solution('1T2D3D#'));
console.log(solution('1D2S3T*'));
