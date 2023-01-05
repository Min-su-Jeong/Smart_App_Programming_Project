# Smart_App_Programming_Project
스마트앱프로그래밍 과목을 수강하면서 개발한 App 관련 프로젝트 Repository입니다.

</br>

## 1. 서론
### 1-1. 개발 목표
- RecyclerView를 사용하여 Backend로부터 받은 데이터를 리스트로 출력
- 웹 기반 클라우드 통합 개발 환경인 GoormIDE에서 MySQL과 Express 프레임워크를 사용하여  
  힙합 관련 음원 데이터베이스를 구축하고 이를 JSON으로 서비스하는 Backend 구축

<br/>

### 1-2. 개발 동기
  - 개발하고자 하는 작품 이름은 ‘HipHop List’이다. 1학기 대학 축제 때, 래퍼들의 힙합 노래를 인상 깊게 
    들으며 즐겁게 놀았던 경험과 이번 ‘SHOW ME THE MONEY 11’ 방송 프로그램의 영향을 받아 해당
    주제로 개발을 기획하게 되었다. 위와 같은 주제로 프로젝트를 개발함으로써 힙합에 관심 있는 사람들이
    APP을 통해 앨범에 대한 상세한 정보를 쉽게 알아볼 수 있도록 만들면 좋겠다는 생각을 하게 되었고
    이를 개발 동기로 하여금 앱 제작 프로젝트를 진행해 볼 예정이다.
 
</br>

### 1-3. 개발 일자

<p align="left">
    <img align="center" width="500" height="270" src="https://user-images.githubusercontent.com/74342121/210741082-3c5c3751-4699-4a4c-a71f-c030393462e2.png">
</p>

</br>

## 2. 작품 개요
### 2.1 전체 구성도

<p align="center">
    <img align="center" width="700" height="120" src="https://user-images.githubusercontent.com/74342121/210733884-77f748dd-3b4f-4915-a31f-9824d57bcf77.png">
</p>

‘Hip Hop List’ APP에 대한 정보는 데이터베이스에서 관리된다. 이는 Mysql 프레임워크를 사용하여 구축하며 APP을 통해 사용자에게 정보를 보여주기 위해서 안드로이드 스튜디오(Android Studio)를 사용한다. 또한, Express 프레임워크를 사용하여 서버를 구축한 후, 데이터베이스에 있는 정보를 JSON 형태로 관리한다. 이를 APP에서 파싱하여 리스트 형태로 메인화면에 출력되도록 한다. 또한, 사용자는 리스트 중에서 원하는 힙합 곡을 클릭하여 해당 앨범에 대한 자세한 정보(곡명, 앨범 이미지, 아티스트 명, 소속사, 발매일 등)를 확인해 볼 수 있도록 한다.

<br/>

## 3. DB Design
### 3-1. Conceptual Design

<p align="center">
    <img align="center" width="500" height="160" src="https://user-images.githubusercontent.com/74342121/210734571-0a58f614-7036-4211-9004-2ba1905dde11.png">
</p>
   
‘Hip Hop List’ 데이터베이스 구성을 E-R 다이어그램으로 나타낸 것이다. 한 소속사에 대해서 다양한 아티스트들이 존재할 수 있으므로 agency와 artist는 1 : N 관계를 가진다. 또한, 한 명의 아티스트는 여러 개의 곡을 작곡하여 발매할 수 있으므로 artist와 song은 1 : N 관계를 가진다. 

<br/>

### 3-2. Logical Design

#### 1. agency
<p align="left">
    <img align="center" width="500" height="100" src="https://user-images.githubusercontent.com/74342121/210736775-49af3433-f669-4eb4-a60a-07fc34c13819.png">
</p>

#### 2. artist
<p align="left">
    <img align="center" width="500" height="150" src="https://user-images.githubusercontent.com/74342121/210736778-c2a7ea29-c494-4428-8eb3-d0cf23de4c16.png">
</p>

#### 3. song
<p align="left">
    <img align="center" width="500" height="150" src="https://user-images.githubusercontent.com/74342121/210736780-d26830ef-6773-43b3-96b9-f372e16ce33e.png">
</p>

</br>

## 4. 구현

   <p align="center">
    <img align="center" width="300" height="500" src="https://user-images.githubusercontent.com/74342121/210737823-8a5df63f-c24a-462d-9b99-6a88704fb30f.png">&nbsp;&nbsp;&nbsp;👉&nbsp;&nbsp;&nbsp;<img align="center" width="300" height="500" src="https://user-images.githubusercontent.com/74342121/210737835-d5c42c8c-84d2-4c26-8ee6-e4110d8d84a8.png">
   </p>
   
   <p align="center">
    <img align="center" width="300" height="500" src="https://user-images.githubusercontent.com/74342121/210738173-d6d93d48-9d53-4dc7-a1ae-5a8a411e94a8.png">&nbsp;&nbsp;&nbsp;👉&nbsp;&nbsp;&nbsp;<img align="center" width="300" height="500" src="https://user-images.githubusercontent.com/74342121/210738179-2d09328d-e730-4e91-8b78-8a1d1305ab1c.png">
   </p>
   
</br>

## 5. 결론
### 5-1. 개발 내용 및 결과 요약
웹 기반 클라우드 통합 개발 환경인 GoormIDE에서 MySQL과 Express 프레임워크를 사용하여 힙합 음원 데이터베이스를 구축하고 이를 JSON으로 서비스하는 Backend 구축하였다. 또한, Android Studio에서 RecyclerView를 사용하여 Backend로부터 받은 데이터를 리스트로 출력하여 사용자에게 정보를 제공할 수 있도록 개발하였다.   
<br/>
힙합 앨범 데이터를 구축하면서 중복되는 속성들이 많았으며 정규화 규칙을 지키기 위해 테이블을 1개에서 3개로 나누어 재구축 하였다. 그 후, 서버에서의 query 문은 2번의 join을 사용하여 힙합 앨범 정보가 모두 담긴 테이블을 생성하도록 코드를 구현하였다.   
<br/>
힙합 앨범에 대한 세부적인 정보를 제공하기 위해 Database에 속성(agency, release_date)을 추가하였으며 Android Studio에서는 SongViewModel.kt에서 Json 형식을 파싱하는 함수 부분에 속성을 추가하였다. 또한, SongActivity에서도 동일하게 추가하였으며 MainActivity의 intent 부분에 추가된 속성을 정의함으로써 APP 내의 상세화면에서 추가한 속성이 출력되도록 Update 하였다.

<br/>

### 5-2. 수행 과정에서 어려웠던 점과 해결방안
수행 과정 중에서 가장 힘들었던 부분은 서버(Express)와 안드로이드 스튜디오의 시뮬레이터와의 데이터 연동이다. 코드 수정 후, 동작을 시킬 때마다 될 때가 있고 안 될 때가 있어 어떤 부분에서 잘못되었는지 찾기가 쉽지 않았다.   
<br/>
이를 해결하기 위해서, 코드 내에 Log 함수를 사용하여 어느 부분에서 에러가 나는지를 찾아보았다. 서버에 관한 에러가 주를 이루었고 점진적으로 Log를 출력해가면서 계속해서 찾아보았다. 결론적으로는 Express에서 json으로 불러오는 것은 문제가 없었는데 시뮬레이터 그 자체에 대해서 문제가 생겨 리스트 형태로 정보를 띄울 수가 없는 것을 알게 되었다. 그래서 시뮬레이터를 다시 삭제 후에 설치하는 방법과 윈도우를 재시작하는 방법 등을 시도해 보며 문제점을 해결할 수 있었다.

<br/> 


## 참고문헌
```
[1] Android 스튜디오 Dolphin l 2021.3.1
https://developer.android.com/studio/releases?hl=ko

[2] RecyclerView로 동적 목록 만들기, Android developers
https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=ko

[3] RecyclerView.ViewHolder, Android developers
https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.ViewHolder

[4] SSH/포트포워딩, Goorm IDE
https://help.goorm.io/ko/goormide/17.various-features/ssh-port-forwarding

[5] Create ER Diagram of a Database in MySQL Workbench, Medium
https://medium.com/@tushar0618/how-to-create-er-diagram-of-a-database-in-mysql-workbench-209fbf63fd03
```
