function solution(id_list, report, k) {
  const answer = [];
  const dic = {};
  for (let item of report) {
    const [a, b] = item.split(' ');

    if (a in dic === false) {
      dic[a] = {
        report: [],
        reportedCount: 0,
      };
    }

    if (b in dic === false) {
      dic[b] = {
        report: [],
        reportedCount: 0,
      };
    }

    if (!dic[a]['report'].includes(b)) {
      dic[a]['report'].push(b);
      dic[b]['reportedCount'] += 1;
    }
  }
  for (let id of id_list) {
    let cnt = 0;
    if (id in dic) {
      for (let item of dic[id]['report']) {
        if (dic[item]['reportedCount'] >= k) {
          cnt += 1;
        }
      }
    }
    answer.push(cnt);
  }
  return answer;
}

console.log(
  solution(
    ['muzi', 'frodo', 'apeach', 'neo'],
    ['muzi frodo', 'apeach frodo', 'frodo neo', 'muzi neo', 'apeach muzi'],
    2,
  ),
);
console.log(
  solution(
    ['con', 'ryan'],
    ['ryan con', 'ryan con', 'ryan con', 'ryan con'],
    3,
  ),
);
