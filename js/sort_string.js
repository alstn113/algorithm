const strings = ['abce', 'abcd', 'cdx'];

strings.sort((a, b) => {
  // 문자열이라서 리턴값 명시해줘야함.
  // return a - b 하면 안 됨.
  if (a > b) return 1;
  if (b > a) return -1;
  return 0;
});

console.log(strings);
// expected output : [ 'abcd', 'abce', 'cdx' ]
