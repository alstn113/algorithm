function solution(s) {
  s = s
    .slice(2, s.length - 2)
    .split('},{')
    .map((v) => v.split(',').map(Number));
  const dic = {};
  for (let i = 0; i < s.length; i++) {
    for (let j = 0; j < s[i].length; j++) {
      const v = s[i][j];
      if (v in dic) {
        dic[v] += 1;
      } else {
        dic[v] = 1;
      }
    }
  }
  const answer = new Array(Object.keys(dic).length).fill(0);
  Object.keys(dic).forEach((v) => (answer[dic[v] - 1] = Number(v)));
  return answer.reverse();
}

console.log(solution('{{2},{2,1},{2,1,3},{2,1,3,4}}'));
console.log(solution('{{1,2,3},{2,1},{1,2,4,3},{2}}'));
console.log(solution('{{20,111},{111}}'));
console.log(solution('{{123}}'));
console.log(solution('{{4,2,3},{3},{2,3,4,1},{2,3}}'));
