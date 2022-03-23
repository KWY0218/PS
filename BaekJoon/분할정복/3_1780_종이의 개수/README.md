# PS
문제풀이

슬라이스를 이용하면 추가 공간이 너무 많이 생기므로

구간을 나눌 d1, d2를 구해서 구간을 나눈다.

그 후 아래 이미지를 참조해서 9개 뿌리를 넓힌다.

![KakaoTalk_20220323_205540254](https://user-images.githubusercontent.com/82709044/159694468-83c35aed-de27-4dd9-b8a4-550fb3e297c9.jpg)

재귀 비용: logN , 비재귀 비용: n^2

O(logN+n^2) = O(n^2)
