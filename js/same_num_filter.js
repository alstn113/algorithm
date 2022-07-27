const arr = [1, 1, 1, 2, 2, 2, 3, 3, 3];
const newArr = arr.filter((cur, idx) => cur != arr[idx - 1]);

console.log(newArr);
// expected outpput : [ 1, 2, 3 ]
