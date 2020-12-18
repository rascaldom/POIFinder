# POIFinder
#### 네이버 지도 SDK 와 지역 검색 API 를 활용한 POI 검색 어플리케이션
#### 검색된 POI 리스트를 선택하면 해당 위치로 지도가 이동하고 마커를 표시


## Summary
- MVVM 패턴과 DI 를 조합하여 전반적인 프레임워크 구조 설계
- 데이터바인딩으로 UI 변경 처리
- Coroutine 활용한 비동기 네트워크 


## Libraries used
- Naver Map SDK
- AAC (Lifecycles, LiveData, ViewModel)
- Coroutine
- Koin
- Retrofit


## issue
- API 가 지원하는 검색결과가 최대 5개로 최대 50개의 POI 검색결과 미구현
- API 요청변수 중 start 변수를 활용하여 최대 50개의 검색결과를 가져오도록 구현 하였지만 start 변수는 1 고정값으로 중복된 결과 초래
