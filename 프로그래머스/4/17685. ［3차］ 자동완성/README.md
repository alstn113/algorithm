# [level 4] [3차] 자동완성 - 17685 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17685) 

### 성능 요약

메모리: 353 MB, 시간: 288.07 ms

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 10월 23일 13:24:51

### 문제 설명

<h2>자동완성</h2>

<p>포털 다음에서 검색어 자동완성 기능을 넣고 싶은 라이언은 한 번 입력된 문자열을 학습해서 다음 입력 때 활용하고 싶어 졌다. 예를 들어, <code>go</code> 가 한 번 입력되었다면, 다음 사용자는 <code>g</code> 만 입력해도 <code>go</code>를 추천해주므로 <code>o</code>를 입력할 필요가 없어진다! 단, 학습에 사용된 단어들 중 앞부분이 같은 경우에는 어쩔 수 없이 다른 문자가 나올 때까지 입력을 해야 한다.<br>
효과가 얼마나 좋을지 알고 싶은 라이언은 학습된 단어들을 찾을 때 몇 글자를 입력해야 하는지 궁금해졌다.</p>

<p>예를 들어, 학습된 단어들이 아래와 같을 때</p>
<div class="highlight"><pre class="codehilite"><code>go
gone
guild
</code></pre></div>
<ul>
<li><code>go</code>를 찾을 때 <code>go</code>를 모두 입력해야 한다.</li>
<li><code>gone</code>을 찾을 때 <code>gon</code> 까지 입력해야 한다. 
(<code>gon</code>이 입력되기 전까지는 <code>go</code> 인지 <code>gone</code>인지 확신할 수 없다.)</li>
<li><code>guild</code>를 찾을 때는 <code>gu</code> 까지만 입력하면 <code>guild</code>가 완성된다.</li>
</ul>

<p>이 경우 총 입력해야 할 문자의 수는 <code>7</code>이다.</p>

<p>라이언을 도와 위와 같이 문자열이 입력으로 주어지면 학습을 시킨 후, 학습된 단어들을 순서대로 찾을 때 몇 개의 문자를 입력하면 되는지 계산하는 프로그램을 만들어보자.</p>

<h3>입력 형식</h3>

<p>학습과 검색에 사용될 중복 없는 단어 <code>N</code>개가 주어진다. <br>
모든 단어는 알파벳 소문자로 구성되며 단어의 수 <code>N</code>과 단어들의 길이의 총합 <code>L</code>의 범위는 다음과 같다.</p>

<ul>
<li>2 &lt;= <code>N</code> &lt;= 100,000</li>
<li>2 &lt;= <code>L</code> &lt;= 1,000,000</li>
</ul>

<h3>출력 형식</h3>

<p>단어를 찾을 때 입력해야 할 총 문자수를 리턴한다.</p>

<h3>입출력 예제</h3>
<table class="table">
        <thead><tr>
<th>words</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>["go","gone","guild"]</td>
<td>7</td>
</tr>
<tr>
<td>["abc","def","ghi","jklm"]</td>
<td>4</td>
</tr>
<tr>
<td>["word","war","warrior","world"]</td>
<td>15</td>
</tr>
</tbody>
      </table>
<h3>입출력 설명</h3>

<ul>
<li>첫 번째 예제는 본문 설명과 같다.</li>
<li>두 번째 예제에서는 모든 단어들이 공통된 부분이 없으므로, 가장 앞글자만 입력하면 된다.</li>
<li>세 번째 예제는 총 <code>15</code> 자를 입력해야 하고 설명은 아래와 같다.

<ul>
<li><code>word</code>는 <code>word</code>모두 입력해야 한다.</li>
<li><code>war</code>는 <code>war</code> 까지 모두 입력해야 한다.</li>
<li><code>warrior</code>는 <code>warr</code> 까지만 입력하면 된다.</li>
<li><code>world</code>는 <code>worl</code>까지 입력해야 한다. (<code>word</code>와 구분되어야 함을 명심하자)</li>
</ul></li>
</ul>

<p><a href="http://tech.kakao.com/2017/11/14/kakao-blind-recruitment-round-3/" target="_blank" rel="noopener">해설 보러가기</a></p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges