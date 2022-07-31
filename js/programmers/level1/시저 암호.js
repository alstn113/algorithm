function solution(s, n) {
  // charCodeAt : 문자열의 특정 인덱스를 유니코드로 변환
  // fromCharCode : 유니코드를 문자열로 변환
  // A(65), Z(90), a(97), z(122)
  answer = '';
  for (let i = 0; i < s.length; i++) {
    if (s[i] == ' ') answer += ' ';
    else
      answer += String.fromCharCode(
        s.charCodeAt(i) > 90
          ? ((s.charCodeAt(i) + n - 97) % 26) + 97
          : ((s.charCodeAt(i) + n - 65) % 26) + 65,
      );
  }

  return answer;
}

console.log(solution('AB', 1));
console.log(solution('z', 1));
console.log(solution('a B z', 4));
