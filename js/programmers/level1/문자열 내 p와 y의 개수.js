function solution(s) {
  let string = [...s.toLowerCase()];
  const answer = string.reduce((acc, cur) => {
    if (cur === 'p') return acc + 1;
    else if (cur === 'y') return acc - 1;
    return acc;
  }, 0);
  return answer === 0 ? true : false;
}

console.log(solution('pPoooyY'));
console.log(solution('Pyy'));
