// 약수의 개수

function divisor(n) {
  let cnt = 0;
  for (let i = 1; i <= Math.sqrt(n); i++) {
    if (i ** 2 == n) cnt += 1;
    else if (n % i == 0) cnt += 2;
  }
  return cnt;
}

console.log(divisor(12));
// expected output : 6
console.log(divisor(16));
// expected output : 5
