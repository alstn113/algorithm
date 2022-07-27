function solution(a, b) {
  let day = new Date(2016, a - 1, b);
  const WEEK = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
  return WEEK[day.getDay()];
}

console.log(solution(5, 24));
