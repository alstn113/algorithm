def solution(n, lost, reserve):
  data = [1]*n
  for j in reserve:
    data[j-1] += 1 
  for i in lost:
    data[i-1] -= 1
  for i in range(n):
    if data[i] == 2:
      if i>0 and data[i-1]==0:
        data[i]=1
        data[i-1]=1
        continue
      if i<n-1 and data[i+1]==0:
        data[i]=1
        data[i+1]=1
        continue
  answer = data.count(1) + data.count(2) 
  return answer