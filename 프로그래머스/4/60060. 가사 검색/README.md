# [level 4] 가사 검색 - 60060 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/60060) 

### 성능 요약

메모리: 518 MB, 시간: 706.99 ms

### 구분

코딩테스트 연습 > 2020 KAKAO BLIND RECRUITMENT

### 채점결과

정확성: 25.0<br/>효율성: 75.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 10월 02일 23:01:39

### 문제 설명

<p><strong>[본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.]</strong></p>

<p>친구들로부터 천재 프로그래머로 불리는 <strong>"프로도"</strong>는 음악을 하는 친구로부터 자신이 좋아하는 노래 가사에 사용된 단어들 중에 특정 키워드가 몇 개 포함되어 있는지 궁금하니 프로그램으로 개발해 달라는 제안을 받았습니다.<br>
그 제안 사항 중, 키워드는 와일드카드 문자중 하나인 '?'가 포함된 패턴 형태의 문자열을 뜻합니다. 와일드카드 문자인 '?'는 글자 하나를 의미하며, 어떤 문자에도 매치된다고 가정합니다. 예를 들어  <code>"fro??"</code>는 <code>"frodo"</code>, <code>"front"</code>, <code>"frost"</code> 등에 매치되지만 <code>"frame"</code>, <code>"frozen"</code>에는 매치되지 않습니다.</p>

<p>가사에 사용된 모든 단어들이 담긴 배열 <code>words</code>와 찾고자 하는 키워드가 담긴 배열 <code>queries</code>가 주어질 때, 각 키워드 별로 매치된 단어가 몇 개인지 <strong>순서대로</strong> 배열에 담아 반환하도록 <code>solution</code> 함수를 완성해 주세요.</p>

<h3>가사 단어 제한사항</h3>

<ul>
<li><code>words</code>의 길이(가사 단어의 개수)는 2 이상 100,000 이하입니다.</li>
<li>각 가사 단어의 길이는 1 이상 10,000 이하로 빈 문자열인 경우는 없습니다.</li>
<li>전체 가사 단어 길이의 합은 2 이상 1,000,000 이하입니다.</li>
<li>가사에 동일 단어가 여러 번 나올 경우 중복을 제거하고 <code>words</code>에는 하나로만 제공됩니다.</li>
<li>각 가사 단어는 오직 알파벳 소문자로만 구성되어 있으며, 특수문자나 숫자는 포함하지 않는 것으로 가정합니다.</li>
</ul>

<h3>검색 키워드 제한사항</h3>

<ul>
<li><code>queries</code>의 길이(검색 키워드 개수)는 2 이상 100,000 이하입니다.</li>
<li>각 검색 키워드의 길이는 1 이상 10,000 이하로 빈 문자열인 경우는 없습니다.</li>
<li>전체 검색 키워드 길이의 합은 2 이상 1,000,000 이하입니다.</li>
<li>검색 키워드는 중복될 수도 있습니다.</li>
<li>각 검색 키워드는 오직 알파벳 소문자와 와일드카드 문자인 <code>'?'</code> 로만 구성되어 있으며, 특수문자나 숫자는 포함하지 않는 것으로 가정합니다.</li>
<li>검색 키워드는 와일드카드 문자인 <code>'?'</code>가 하나 이상 포함돼 있으며, <code>'?'</code>는 각 검색 키워드의 접두사 아니면 접미사 중 하나로만 주어집니다.

<ul>
<li>예를 들어 <code>"??odo"</code>, <code>"fro??"</code>, <code>"?????"</code>는 가능한 키워드입니다.</li>
<li>반면에 <code>"frodo"</code>(<code>'?'</code>가 없음), <code>"fr?do"</code>(<code>'?'</code>가 중간에 있음), <code>"?ro??"</code>(<code>'?'</code>가 양쪽에 있음)는 불가능한 키워드입니다.</li>
</ul></li>
</ul>

<h3>입출력 예</h3>
<table class="table">
        <thead><tr>
<th>words</th>
<th>queries</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td><code>["frodo", "front", "frost", "frozen", "frame", "kakao"]</code></td>
<td><code>["fro??", "????o", "fr???", "fro???", "pro?"]</code></td>
<td><code>[3, 2, 4, 1, 0]</code></td>
</tr>
</tbody>
      </table>
<h3>입출력 예에 대한 설명</h3>

<ul>
<li><code>"fro??"</code>는 <code>"frodo"</code>, <code>"front"</code>, <code>"frost"</code>에 매치되므로 3입니다.</li>
<li><code>"????o"</code>는 <code>"frodo"</code>, <code>"kakao"</code>에 매치되므로 2입니다.</li>
<li><code>"fr???"</code>는 <code>"frodo"</code>, <code>"front"</code>, <code>"frost"</code>, <code>"frame"</code>에 매치되므로 4입니다.</li>
<li><code>"fro???"</code>는 <code>"frozen"</code>에 매치되므로 1입니다.</li>
<li><code>"pro?"</code>는 매치되는 가사 단어가 없으므로 0 입니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges