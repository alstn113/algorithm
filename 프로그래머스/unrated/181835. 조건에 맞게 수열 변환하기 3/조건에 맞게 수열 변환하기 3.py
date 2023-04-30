def solution(arr, k):
    return [v+k for v in arr] if k%2 == 0 else [v*k for v in arr]