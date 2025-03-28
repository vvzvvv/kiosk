# 🍔 키오스크 프로그램

**소프트웨어 분석 및 설계** 를 공부하며 진행한 키오스크 시스템 프로젝트입니다.  
유스케이스 정의, 클래스 식별, 시퀀스 다이어그램 등 분석 및 설계 과정을 거쳐 Java Swing으로 구현했습니다.

---

## 기능 요약
| 기능            | 설명 |
|----------------|------|
| 메뉴 출력       | 메뉴 이름, 가격, 재고 표시 및 버튼화 |
| 품절 처리       | 재고가 0일 경우 버튼 비활성화 및 "품절" 표시 |
| 장바구니        | 선택한 항목을 장바구니에 추가, 수량 누적 |
| 장바구니 보기   | 현재 장바구니 내역 및 총 금액 확인 |
| 결제            | 쿠폰 입력 후 할인 적용, 결제 완료 메시지 표시 |

---

## 분석 및 설계 과정
### ✅ 클래스 정의
<img width="944" alt="Image" src="https://github.com/user-attachments/assets/250de5c2-ed1d-4a24-8059-07cfec55a43b" />

### ✅ 클래스 다이어그램
<img width="674" alt="스크린샷 2025-03-28 오후 11 58 12" src="https://github.com/user-attachments/assets/5f9946a2-8c6b-4fc8-bfa3-36d6d204cd6c" />

### ✅ 유스케이스 다이어그램 - 시나리오 명세
<img width="870" alt="스크린샷 2025-03-27 오전 3 31 07" src="https://github.com/user-attachments/assets/d84bf7f5-4cb9-475a-be97-07d3264a6b55" />
<img width="870" alt="스크린샷 2025-03-27 오전 3 31 33" src="https://github.com/user-attachments/assets/193a58d3-e1aa-4c0c-ac19-962dd31ee66b" />
<img width="870" alt="스크린샷 2025-03-27 오전 3 32 10" src="https://github.com/user-attachments/assets/0f255b9e-47a5-452d-b4a9-dcb6ce1617a1" />

### ✅ 유스케이스 다이어그램
<img width="811" alt="스크린샷 2025-03-29 오전 12 00 01" src="https://github.com/user-attachments/assets/d4772de0-10aa-4727-bd76-f4e8adb889b9" />


### ✅ 시퀀스 다이어그램
<img width="723" alt="스크린샷 2025-03-27 오전 3 36 55" src="https://github.com/user-attachments/assets/22135608-57c5-4918-9cbd-5b16df1fde8c" />
<img width="723" alt="스크린샷 2025-03-27 오전 3 37 16" src="https://github.com/user-attachments/assets/3e7de40d-2cbf-450d-a1b7-14bc19cd630a" />

---

## 실행 화면
- 시작 화면
  <img width="700" alt="스크린샷 2025-03-29 오전 12 03 26" src="https://github.com/user-attachments/assets/7b08d41c-f30e-4fdc-b255-010ea8581306" />
- 메뉴 선택 (재고 없으면 품절 처리)
  <img width="700" alt="스크린샷 2025-03-29 오전 12 03 47" src="https://github.com/user-attachments/assets/83f59ab3-99ef-4e85-a4b2-1d2ffe2eb0e6" />
- 장바구니
  <img width="703" alt="스크린샷 2025-03-29 오전 12 05 11" src="https://github.com/user-attachments/assets/1601c31b-d921-47b0-8dbe-8226d712592c" />

- 결제_쿠폰입력
  <img width="703" alt="스크린샷 2025-03-29 오전 12 05 33" src="https://github.com/user-attachments/assets/f6e1bb9f-f44a-4419-bae0-544640aec05a" />
  
- 결제 완료 
  <img width="706" alt="스크린샷 2025-03-29 오전 12 06 07" src="https://github.com/user-attachments/assets/ccce416d-6c48-46ca-99df-0408614e7d01" />
