const fs = require("fs");
//const file = "/dev/stdin";
const file = "input.txt";
let input = fs.readFileSync(file).toString().trim().split("\n");

const T = Number(input[0]);
const queue = [];
const result = [];
for (let i = 1; i < T + 1; i++) {
  const a = Number(input[i]);
  if (a > 0) {
    queue.push(a);
  } else {
    if (queue.length !== 0) {
      queue.sort((a, b) => a - b);
      const v = queue.pop();
      result.push(v);
    } else {
      result.push(0);
    }
  }
}

console.log(result.join("\n"));
