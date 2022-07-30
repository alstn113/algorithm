function solution(s) {
  const answer = [...s].sort((a, b) => {
    if (a > b) return -1;
    else if (a < b) return 1;
    else return 0;
  });
  return answer.join('');
}

console.log(solution('Zbcdefg'));
