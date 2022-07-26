function solution(participant, completion) {
  const dic = {};
  for (let c of completion) {
    if (c in dic) {
      dic[c] += 1;
    } else {
      dic[c] = 1;
    }
  }
  for (let p of participant) {
    if (p in dic === false || dic[p] == 0) {
      return p;
    } else {
      dic[p] -= 1;
    }
  }
}

console.log(solution(['leo', 'kiki', 'eden'], ['eden', 'kiki']));
console.log(
  solution(
    ['marina', 'josipa', 'nikola', 'vinko', 'filipa'],
    ['josipa', 'filipa', 'marina', 'nikola'],
  ),
);
console.log(
  solution(['mislav', 'stanko', 'mislav', 'ana'], ['stanko', 'ana', 'mislav']),
);
