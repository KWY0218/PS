# PS
문제: https://www.acmicpc.net/problem/2630

4 사분면을 나눠서 분할정복하면 된다.

![2](https://user-images.githubusercontent.com/82709044/159418923-308ca8aa-b412-4187-b75c-fb2c08689ad6.jpg)

우선 범위 내에 있는 수를 전부 더해서 0일 땐 박스 내에 전부 0이 들었으므로, answer[0]의 값을 1 증가하고,

박스의 넓이와 같을 땐 박스 내에 전부 1이 들어있으므로, answer[1]의 값을 1 증가한다.

둘 다 아닐 땐 박스의 사이즈를 2배 감소한다.

만약 1x1 박스가 되면, 해당 박스의 값을 1 증가시킨다.

### 예시

![1](https://user-images.githubusercontent.com/82709044/159419109-e3c600e8-01c0-4e07-ad2b-5acbda9b11b1.jpg)

![3](https://user-images.githubusercontent.com/82709044/159419223-bd407fe6-c732-43d3-8ae1-dc3f4a98e5fe.jpg)

### 시간 복잡도
재귀 비용: log n, 비재귀 비용: n^2 이므로

O(logN+n^2)

O(n^2) 이다.