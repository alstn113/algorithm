function changeTimeToNumber(time) {
  const [a, b] = time.split(':').map(Number);
  return a * 60 + b;
}

function calc(time, fees) {
  const [standardTime, standardFee, unitTime, unitFee] = fees;
  if (time <= standardTime) return standardFee;
  return standardFee + Math.ceil((time - standardTime) / unitTime) * unitFee;
}

function solution(fees, records) {
  const dic = {};
  for (let i = 0; i < records.length; i++) {
    const [time, num, status] = records[i].split(' ');
    if (num in dic === false) {
      dic[num] = { time: changeTimeToNumber(time), status, sum: 0 };
    } else {
      if (status === 'OUT') {
        dic[num].status = 'OUT';
        dic[num].sum += changeTimeToNumber(time) - dic[num].time;
        dic[num].time = 0;
      } else {
        dic[num].time = changeTimeToNumber(time);
        dic[num].status = 'IN';
      }
    }
  }
  let result = [];
  Object.keys(dic)
    .sort((a, b) => Number(a) - Number(b))
    .forEach((v) => {
      if (dic[v].status === 'OUT') {
        result.push(calc(dic[v].sum, fees));
      } else {
        const lastTime = changeTimeToNumber('23:59');
        const sum = dic[v].sum + lastTime - dic[v].time;
        result.push(calc(sum, fees));
      }
    });

  return result;
}

console.log(
  solution(
    [180, 5000, 10, 600],
    [
      '05:34 5961 IN',
      '06:00 0000 IN',
      '06:34 0000 OUT',
      '07:59 5961 OUT',
      '07:59 0148 IN',
      '18:59 0000 IN',
      '19:09 0148 OUT',
      '22:59 5961 IN',
      '23:00 5961 OUT',
    ],
  ),
);
console.log(
  solution(
    [120, 0, 60, 591],
    [
      '16:00 3961 IN',
      '16:00 0202 IN',
      '18:00 3961 OUT',
      '18:00 0202 OUT',
      '23:58 3961 IN',
    ],
  ),
);
console.log(solution([1, 461, 1, 10], ['00:00 1234 IN']));
