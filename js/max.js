console.log(Math.max(1, 2, 3));

const array = [1, 2, 3];
console.log(Math.max(...array));
console.log(Math.max.apply(null, array));
