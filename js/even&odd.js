// 비트연산자 &로 홀짝 판별하기
// 제일 오른쪽 비트만으로 판별함
function isOdd(n) {
  return n & 1 ? true : false;
}

console.log(isOdd(15));
// expected output : true

console.log(isOdd(12));
// expected output : true
