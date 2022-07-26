function distance(a, b) {
  return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
}

function solution(numbers, hand) {
  const keypad = {
    1: [0, 0],
    2: [0, 1],
    3: [0, 2],
    4: [1, 0],
    5: [1, 1],
    6: [1, 2],
    7: [2, 0],
    8: [2, 1],
    9: [2, 2],
    0: [3, 1],
  };
  let answer = '';
  let left = [3, 0];
  let right = [3, 2];

  for (let key of numbers) {
    if ([1, 4, 7].includes(key)) {
      answer += 'L';
      left = keypad[key];
    } else if ([3, 6, 9].includes(key)) {
      answer += 'R';
      right = keypad[key];
    } else {
      const leftDistance = distance(left, keypad[key]);
      const rightDistance = distance(right, keypad[key]);

      if (leftDistance > rightDistance) {
        right = keypad[key];
        answer += 'R';
      } else if (leftDistance < rightDistance) {
        left = keypad[key];
        answer += 'L';
      } else {
        if (hand === 'right') {
          right = keypad[key];
          answer += 'R';
        } else {
          left = keypad[key];
          answer += 'L';
        }
      }
    }
  }
  return answer;
}

console.log(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right'));
console.log(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], 'left'));
console.log(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], 'right'));
