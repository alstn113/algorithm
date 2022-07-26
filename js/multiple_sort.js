const array = [
  [4, 2],
  [1, 2],
  [4, 1],
  [3, 3],
];

array.sort((a, b) => {
  // step 1
  if (a[0] > b[0]) return 1;
  else if (a[0] < b[0]) return -1;
  // step 2
  else if (a[1] > b[1]) return 1;
  else if (a[1] < b[1]) return -1;
  // or return a[1] - b[1]
});

console.log(array);
//  [ [ 1, 2 ], [ 3, 3 ], [ 4, 1 ], [ 4, 2 ] ]
