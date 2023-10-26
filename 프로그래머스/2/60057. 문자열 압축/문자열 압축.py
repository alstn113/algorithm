import sys
input = sys.stdin.readline


def compress(s, i):
    """
    문자열 s를 i 단위로 압축한 결과를 반환하는 함수
    """
    result = ""
    cnt = 0
    temp_str = ""
    # 문자열 압축 단위로 끊어 읽기에 대한 반복문
    for j in range(0, len(s), i):
        current_str = s[j:j+i]
        # 이전 값과 같으면 압축
        if temp_str == current_str:
            cnt += 1
        # 이전 값과 다르면 result에 추가
        else:
            # cnt = 1인 경우에는 숫자 추가 불필요
            if cnt > 1:
                result += str(cnt)
            result += current_str
            cnt = 1
            temp_str = current_str
    if cnt > 1:
        result += str(cnt)

    return result


def solution(s):
    answer = len(s)
    # 문자열 압축 단위에 대한 반복문
    # s 길이의 절반을 넘으면 압축 불가능 -> 절반까지만 반복
    for i in range(1, len(s)//2 + 1):
        compressed = compress(s, i)
        answer = min(answer, len(compressed))
    return answer


if __name__ == "__main__":
    print(solution("aabbaccc"))
    print(solution("ababcdcdababcdcd"))
    print(solution("abcabcdede"))
    print(solution("abcabcabcabcdededededede"))
    print(solution("xababcdcdababcdcd"))
    print(solution("aaaaaaaaaa"))
