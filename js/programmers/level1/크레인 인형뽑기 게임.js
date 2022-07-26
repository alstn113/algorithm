function solution(board, moves) {
  const stack = [];
  const len = board[0].length;
  let result = 0;
  for (let move of moves) {
    let i = 0;
    while (i < len) {
      if (board[i][move - 1] !== 0) {
        if (
          stack.length > 0 &&
          stack[stack.length - 1] === board[i][move - 1]
        ) {
          stack.pop();
          result += 2;
        } else {
          stack.push(board[i][move - 1]);
        }
        board[i][move - 1] = 0;
        break;
      }
      i++;
    }
  }

  return result;
}

console.log(
  solution(
    [
      [0, 0, 0, 0, 0],
      [0, 0, 1, 0, 3],
      [0, 2, 5, 0, 1],
      [4, 2, 4, 4, 2],
      [3, 5, 1, 3, 1],
    ],
    [1, 5, 3, 5, 1, 2, 1, 4],
  ),
);
