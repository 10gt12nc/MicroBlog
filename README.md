# 微網誌MicroBlog 

開發人員:林廸凱

## 專案說明 ##

主要目標在展現後端能力，此專案實現了增、刪、改、查、使用JavaMail驗證使用者以及找回密碼等功能。
以J2EE為基礎套用Spring做了頁面配置Controller，未來將持續更新，目標是開發更完整的論壇系統。
 
1.使用技術 :
JAVA、Servlet、JSP、J2EE、Spring、Ajax、JSON、RWD、Bootstrap
2.使用工具 : 
Maven、Github、Eclipse、Visual Studio Code
3.專案環境 : 
OS-Windows、Tomcat、MySQL

4.(測試用帳密)
GMail:
linmicroblog@gmail.com
l123d456k789

MySQL:
root
123456

## 微網誌功能 ##
基於MVC架構:
1.前置作業:
1-2.bean資料夾,會員與訊息class,有屬性set get
1-3.MySQL資料庫,對應bean 創建會員與訊息table
1-4.controller資料夾,Servlet以及Spring網頁配置器
1-5.dao資料夾,會員與訊息方法,用於存取資料
1-6.daoImpl資料夾,實作dao
1-7.factory資料夾,多型  鬆散 控制權
1-8.filter資料夾,UTF-8編碼攔截器::、登入後才可進入會員專區攔截器::、註冊格式攔截器::
(未來將AOP改寫)
1-9.utils資料夾, 資料庫連結用
(未來將用Spring 管理資料庫連結 )
1-10.unity Test資料夾, 單元測試
1-11.pom.xml  , Mevan管理Spring jar檔
1-12.web.xml ,<error-page>
1-13. 所有view視圖在WEB-INF下 做簡單的安全
1-14.Github版控,由於是小專案,沒有使用分支等功能

2.流程與詳細說明:
2-1 web.xml一載入,會先跑index.jsp以及啟動springmvc 
因為做了基本的網頁安全所以將所有view視圖放在WEB-INF下,最初index.jsp使用jsp:forward轉發到首頁。之後都會是用Spring網頁配置器和Servlet轉發至Views。
2-2 首頁使用Ajax+JSON實作異步功能,自動更新資訊
 在Servlet 使用工廠達到多型結構
 撈取公開訊息的方法,回傳list後
將list 轉成JSON 結構
response回來首頁

2-3 註冊
驗證格式使用 正規表示式
岩質

Gmail驗證
2-4 登入
由於有session 判斷 顯示不同內容


2-5 公開/隱藏訊息
2-5 刪除
2-6 編輯訊息
2-7 修改密碼 
2-5 忘記密碼 
Gmail


## 工作日誌 ##

<ol><h5>2020/9/3</h5>
	<li>測試成功jQuery+Ajax+JSON撈後臺訊息</li>
	<li>Ajax網頁異步更新並自動刷新</li>
</ol>
<ol><h5>2020/9/1</h5>
	<li>整理完畢,功能正常</li>
	<li>問題:網址列出現Servlet(未修)</li>
	<li>問題:重設密碼最小字數限制(未修)</li>
	<li>開始製作前端頁面</li>
</ol>
<ol><h5>2020/8/31</h5>
	<li>整理程式碼、資料結構</li>
	<li>增加Spring網頁配置器</li>
	<li>學習JQuery、Ajax回撈資訊到首頁</li>
</ol>
<ol><h5>2020/8/10</h5>
		<li>套用Spring框架,重構</li>
		<li>使用Maven管理</li>
	</ol>
	<ol><h5>2020/7/11~8/8</h5>
		<li>學習框架:Spring,Struts,Hibernate,JPA</li>
	</ol>
	<ol><h5>2020/7/10</h5>
		<li>忘記密碼使用郵件取回</li>
	</ol>
	<ol><h5>2020/7/7</h5>
		<li>重構</li>
		<li>增加重設密碼功能</li>
		<li>輸入帳號、郵件同頁面顯示舊密碼</li>
	</ol>
	<ol><h5>2020/7/6</h5>
		<li>使用郵件開通會員</li>
		<li>新增鹽值</li>
	</ol>
	<ol><h5>2020/7/3</h5>
		<li>使用JavaMail由網頁發送郵件</li>
	</ol>
	<ol><h5>2020/6/30</h5>
		<li>會員可將訊息公開或隱藏</li>
		<li>增加公開訊息10筆至首頁</li>
	</ol>
	<ol><h5>2020/6/29</h5>
		<li>重構</li>
		<li>增加編輯訊息功能</li>
		<li>將"login設為username"方法抽取出至DAO</li>
		<li>使用EL、JSTL</li>
		<li>前端頁面簡單佈置</li>
	</ol>
	<ol><h5>2020/6/28</h5>
		<li>建立Message表單</li>
		<li>加入Session：
			<ul>
				<li>登入設login屬性，重設SessionID</li>
				<li>登入憑證過濾器</li>
				<li>登出Session失效</li>
			</ul>
		</li>
				<li>會員訊息管理：
			<ul>
				<li>會員能看留言版</li>
				<li>新增訊息</li>
				<li>刪除訊息</li>		
			</ul>
		</li>
	</ol>
	<ol><h5>2020/6/26、27</h5>
		<li>使用MVC架構,GitHub版控
			<ul>
				<li>Model:
					<ul>bean</ul>
					<ul>dao介面</ul>
					<ul>daoImpl實作</ul>
					<ul>db連接</ul>
					<ul>工廠</ul>
					<ul>junit test單元測試</ul>
					<ul>filter</ul>
				</li>
				<li>View:
					<ul>JSP</ul>
				</li>
				<li>Controller:
					<ul>Servlet</ul>
				</li>
			</ul>
		</li>
		<li>建立MySQL會員表單</li>
		<li>會員申請：
			<ul>
				<li>會員註冊頁面</li>
				<li>會員註冊過濾器</li>
				<li>會員註冊控制器</li>
				<li>UTF-8字元過濾器</li>
				<li>註冊表單填寫成功頁面</li>
			</ul>
		</li>
				<li>會員登入：
			<ul>
				<li>會員登入頁面</li>
				<li>會員登入控制器</li>		
				<li>登入成功頁面</li>
			</ul>
		</li>
	</ol>
	