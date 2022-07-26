function score(answers, p) {
  return answers.reduce(
    (acc, cur, idx) => acc + (p[idx % p.length] === cur && 1),
    0,
  );
}

function solution(answers) {
  const answer = [];

  const p1 = [1, 2, 3, 4, 5];
  const p2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

  const s1 = score(answers, p1);
  const s2 = score(answers, p2);
  const s3 = score(answers, p3);

  const max = Math.max(s1, s2, s3);
  if (s1 === max) answer.push(1);
  if (s2 === max) answer.push(2);
  if (s3 === max) answer.push(3);

  return answer;
}

console.log(solution([1, 2, 3, 4, 5]));
console.log(solution([1, 3, 2, 4, 2]));
