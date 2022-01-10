const fs = require("fs");
//const file = "/dev/stdin";
const file = "input.txt";
let input = fs.readFileSync(file).toString().trim().split("\n");

const N = +input[0];
const paper = [];
const result = [0, 0];
for (let i = 1; i <= N; i++) {
  paper.push(input[i].split(" ").map(Number));
}
check(0, 0, N);
console.log(result.join("\n"));

function check(y, x, size) {
  const first = paper[y][x];
  let isSame = true;
  for (let i = y; i < y + size; i++) {
    for (let j = x; j < x + size; j++) {
      if (paper[i][j] != first) {
        isSame = false;
        break;
      }
    }
    if (isSame == false) {
      break;
    }
  }
  if (isSame) {
    result[first] += 1;
    return;
  }
  check(y, x, size / 2);
  check(y + size / 2, x, size / 2);
  check(y, x + size / 2, size / 2);
  check(y + size / 2, x + size / 2, size / 2);
}
