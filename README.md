# MyBatis-hands-on
## 第9回課題「MyBatisを使ってReadを実装する」を提出
### 実装内容
+ "/songs"で、データベースから一覧が返ってくる。
+ "/songs/{published_year}"で、発売年が入っているカラム「year」から、該当するレコードが返ってくる。
  - 該当するレコードがなかった場合は、404エラーが返される。
### 実行結果
##### ★一覧を取得
![image](https://user-images.githubusercontent.com/105856391/215997182-84c10ac7-ff8e-4136-8857-87e9da33c278.png)
#### ★2022年発売のものを取得
![image](https://user-images.githubusercontent.com/105856391/215997398-a11739b4-243c-490a-b4ca-a398d4cb0e14.png)
#### ★該当するレコードがない場合
![image](https://user-images.githubusercontent.com/105856391/215997809-a06590c1-8274-42b9-9bb7-4a59ed76c3b1.png)

