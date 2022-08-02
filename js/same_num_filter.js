const array = [1, 1, 2, 2, 3, 4, 5];
const newArr = array.filter((cur, idx) => cur != array[idx - 1]);

console.log(newArr);
