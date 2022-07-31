function isPrime(n) {
  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i == 0) return false;
  }
  return true;
}

console.log(isPrime(5));
// expected output : true

console.log(isPrime(7));
// expected output : true

console.log(isPrime(8));
// expected output : false
