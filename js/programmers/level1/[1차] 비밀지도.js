function solution(n, arr1, arr2) {
  arr1 = arr1.map((v) => v.toString(2).padStart(n, '0'));
  arr2 = arr2.map((v) => v.toString(2).padStart(n, '0'));
  const result = [];

  for (let i = 0; i < n; i++) {
    let s = '';
    for (let j = 0; j < n; j++) {
      if (arr1[i][j] == 1 || arr2[i][j] == 1) {
        s += '#';
      } else {
        s += ' ';
      }
    }
    result.push(s);
  }
  return result;
}

console.log(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]));
console.log(solution(6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]));
