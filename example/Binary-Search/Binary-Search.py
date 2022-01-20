import sys

def binary_search(array, target, start, end):
  while start<=end:
    mid = (start + end)//2
    if array[mid] == target:
      return mid
    elif array[mid] > target:
      end = mid-1
    else:
      start = mid+1
  return None

#원소 개수, 찾을려는 수
n, target = list(map(int, sys.stdin.readline().split()))
#전체 원소 배열
array = list(map(int, sys.stdin.readline().split()))

result = binary_search(array, target, 0, n-1)
if result == None:
  print("원소가 존재하지 않습니다")
else:
  print(result+1)