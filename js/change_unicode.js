// charCodeAt : 문자열의 특정 인덱스를 유니코드로 변환
// fromCharCode : 유니코드를 문자열로 변환
// a(65), z(90), A(97), Z(122)

console.log(String.fromCharCode(65));
// expeceted output : "A"

console.log(String.fromCharCode(97, 122));
// expeceted output : "az"

const s = 'AZ';
console.log(s.charCodeAt(0));
// expected output : 65
