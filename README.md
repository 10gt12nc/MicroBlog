# 微網誌MicroBlog 

開發人員:林廸凱

## 專案說明 ##
目前進度:
J2EE做的圍網誌的曾刪改查等功能正常
改寫spring
未來方向:
方案一 : 新增版面,完整更新為論壇系統,可發帖回帖等
翻案二 : 套用基本spring


使用技術 :
J2EE、Spring、RWD、Bootstrap
使用工具 : 
Maven、Github、Eclipse、Visual Studio Code
專案環境 : 
OS-Windows、Tomcat、MySQL


## 微網誌功能 ##
1.	
2.	
3.	
4.
## 微網誌畫面 ##

1.	增
2.	刪
3.	改
4.	查

(https://github.com/)


## 工作日誌 ##

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
		<li>使用Model2 架構,GitHub版控
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
				<li>會員註冊.jsp</li>
				<li>會員註冊過濾器</li>
				<li>會員註冊控制器</li>
				<li>UTF-8字元過濾器</li>
				<li>註冊表單填寫成功.jsp</li>
			</ul>
		</li>
				<li>會員登入：
			<ul>
				<li>會員登入.jsp</li>
				<li>會員登入控制器</li>		
				<li>登入成功.jsp</li>
			</ul>
		</li>
	</ol>
	