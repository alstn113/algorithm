function solution(id_list, report, k) {
  const answer = [];
  const dic = {};
  id_list.map((id) => (dic[id] = { report: [], reportedCount: 0 }));
  for (let item of report) {
    const [reporter, reportedId] = item.split(' ');

    if (!dic[reporter]['report'].includes(reportedId)) {
      dic[reporter]['report'].push(reportedId);
      dic[reportedId]['reportedCount'] += 1;
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
