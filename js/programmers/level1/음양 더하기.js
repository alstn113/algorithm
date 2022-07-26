function solution(absolutes, signs) {
  let answer = 0;
  for (let i = 0; i < absolutes.length; i++) {
    answer += signs[i] ? absolutes[i] : -absolutes[i];
  }
  return answer;
}
// reduce를 사용한 풀이
// absolutes.reduce((acc, cur, i) => acc + cur * (signs[i] ? 1 : -1), 0)
// 설명 : absolutes.reduce((누적값, 현재값, 인덱스) => 누적값 + 현재값 * (절댓값관련), 초기값)

console.log(solution([4, 7, 12], [true, false, true]));
console.log(solution([1, 2, 3], [false, false, true]));
